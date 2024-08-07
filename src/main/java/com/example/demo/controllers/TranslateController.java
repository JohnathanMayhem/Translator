package com.example.demo.controllers;

import com.example.demo.messages.TranslateRequest;
import com.example.demo.services.TranslatorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranslateController {

    @Autowired
    TranslatorService translatorService;

    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    public String translate(@RequestBody TranslateRequest translateRequest, HttpServletRequest request) {
        return translatorService.translate(request.getRemoteAddr(), translateRequest.getText(),
                translateRequest.getSourceLanguage(), translateRequest.getTargetLanguage());
    }
}
