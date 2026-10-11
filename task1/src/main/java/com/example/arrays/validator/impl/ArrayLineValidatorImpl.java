package com.example.arrays.validator.impl;

import com.example.arrays.validator.ArrayLineValidator;

public class ArrayLineValidatorImpl implements ArrayLineValidator {

    // Appendix 1, п.9: регулярные выражения — в константы
    private static final String VALID_LINE_PATTERN =
            "^\\s*-?\\d+([.,]\\d+)?(\\s*[;,\\-\\s]\\s*-?\\d+([.,]\\d+)?)*\\s*$";
    private static final String EMPTY_LINE_PATTERN = "^\\s*$";

    @Override
    public boolean isValid(String line) {
        if (line == null) {
            return false;
        }
        if (line.matches(EMPTY_LINE_PATTERN)) {
            return true;
        }
        return line.matches(VALID_LINE_PATTERN);
    }
}