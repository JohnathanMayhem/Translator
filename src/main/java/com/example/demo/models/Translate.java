package com.example.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Data
@Table("TRANSLATES")
public class Translate {
    @Id
    long id;
    String ip_id;
    String input_text;
    String output_text;
    String input_language;
    String output_language;

    public Translate(String ip_id, String input_text, String output_text, String input_language, String output_language) {
        this.ip_id = ip_id;
        this.input_text = input_text;
        this.output_text = output_text;
        this.input_language = input_language;
        this.output_language = output_language;
    }
}
;