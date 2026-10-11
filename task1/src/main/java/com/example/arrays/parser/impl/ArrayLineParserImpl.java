package com.example.arrays.parser.impl;

import com.example.arrays.exception.ArrayProcessingException;
import com.example.arrays.parser.ArrayLineParser;

public class ArrayLineParserImpl implements ArrayLineParser {

    private static final String DELIMITER_PATTERN = "\\s*[;,\\-\\s]\\s*";
    private static final String EMPTY_LINE_PATTERN = "^\\s*$";

    @Override
    public Integer[] parseToIntegerArray(String line) {
        String[] tokens = splitLine(line);
        Integer[] result = new Integer[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i].trim());
        }
        return result;
    }

    @Override
    public Double[] parseToDoubleArray(String line) {
        String[] tokens = splitLine(line);
        Double[] result = new Double[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Double.parseDouble(tokens[i].trim().replace(',', '.'));
        }
        return result;
    }

    private String[] splitLine(String line) {
        if (line == null || line.matches(EMPTY_LINE_PATTERN)) {
            throw new ArrayProcessingException("Line is null or empty");
        }
        return line.trim().split(DELIMITER_PATTERN);
    }
}