package com.example.demo.models;

import java.util.HashSet;


public class LanguageUtil {
    public static HashSet languagesSet;
    static {
        languagesSet = new HashSet();
        languagesSet.add("en");
        languagesSet.add("fr");
        languagesSet.add("de");
        languagesSet.add("es");
        languagesSet.add("pt");
        languagesSet.add("nl");
        languagesSet.add("ru");
        languagesSet.add("tr");
        languagesSet.add("zh");
    }
    public static boolean isValidLanguage(String language) {
        language = language.toLowerCase();
        return languagesSet.contains(language);
    }
}
