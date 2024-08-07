package com.example.demo.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TranslateRequest {
    @JsonProperty("sourceLanguage")
    private String sourceLanguage;
    @JsonProperty("targetLanguage")
    private String targetLanguage;
    @JsonProperty("text")
    private String text;


}
