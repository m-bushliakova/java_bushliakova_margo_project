package com.example.arrays.parser;

public interface ArrayLineParser {
    Integer[] parseToIntegerArray(String line);
    Double[] parseToDoubleArray(String line);
}