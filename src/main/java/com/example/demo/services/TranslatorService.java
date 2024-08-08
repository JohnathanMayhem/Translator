package com.example.demo.services;

import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@Service
@EnableAsync
public class TranslatorService {

    @Autowired
    RequestInfoRepo requestInfoRepo;

    @Autowired
    TranslatesRepo translatesRepo;

    @Autowired
    WordTranslator wordTranslator;

    private final Executor taskExecutor;

    public TranslatorService(@Qualifier("translatorTaskExecutor") Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Async
    public CompletableFuture<String> translateWordAsync(String word, String fromLang, String toLang) {
        return CompletableFuture.supplyAsync(() -> wordTranslator.translate(word, fromLang, toLang), taskExecutor);
    }

    public String translate(String ip, String text, String fromLang, String toLang) {
        if (!(LanguageUtil.isValidLanguage(fromLang) && LanguageUtil.isValidLanguage(toLang))) {
            throw new NoSuchLanguageException("Illegal language");
        }
        List<String> words = Arrays.asList(text.split(" "));
        List<CompletableFuture<String>> translatedWords = words.stream()
                .map(word -> translateWordAsync(word, fromLang, toLang))
                .toList();

        String translatedText = translatedWords.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        if (!requestInfoRepo.existsByIp(ip)){
            requestInfoRepo.save(new RequestInfo(ip));
        }
        translatesRepo.save(new Translate(ip, text, translatedText, fromLang, toLang));
        return translatedText;
    }
}
