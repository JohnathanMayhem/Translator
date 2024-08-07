package com.example.demo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class WordTranslator {
    public String translate(String word, String inputLanguage, String outputLanguage) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://script.google.com/macros/s/AKfycbxGAKczGcTcnaHVthRIO-BibjB5QxefLzgi5ADDpJlzaLQ10IeLcFBxsQMC6b9UkH7IVw/exec")
                .queryParam("q", URLEncoder.encode(word, StandardCharsets.UTF_8))
                .queryParam("target", outputLanguage)
                .queryParam("source", inputLanguage);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
