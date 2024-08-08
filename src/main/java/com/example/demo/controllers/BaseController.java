package com.example.demo.controllers;

import com.example.demo.models.ErrorObject;
import com.example.demo.models.NoSuchLanguageException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BaseController {
    @ExceptionHandler(NoSuchLanguageException.class)
    void handle(HttpServletResponse response, NoSuchLanguageException ex) throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        ObjectMapper mapper = new ObjectMapper();
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()))) {
            bw.write(mapper.writeValueAsString(new ErrorObject("Redirection not found by key " + ex.getMessage())));
        }
    }
}
