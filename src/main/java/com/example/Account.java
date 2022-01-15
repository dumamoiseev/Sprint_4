package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;
    private static final String NAME_PATTERN = "(?=.{3,19}$)[а-яА-Яa-zA-Z]+\\s{1}[а-яА-Яa-zA-Z]+";
    private static final Pattern namePattern = Pattern.compile(NAME_PATTERN);

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        Matcher matcher = namePattern.matcher(name);
        return matcher.matches();
    }
}