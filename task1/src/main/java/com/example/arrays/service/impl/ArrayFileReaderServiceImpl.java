package com.example.arrays.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.arrays.entity.ArrayWrapper;
import com.example.arrays.exception.ArrayProcessingException;
import com.example.arrays.factory.ArrayFactory;
import com.example.arrays.parser.ArrayLineParser;
import com.example.arrays.service.ArrayFileReaderService;
import com.example.arrays.validator.ArrayLineValidator;

public class ArrayFileReaderServiceImpl implements ArrayFileReaderService {

    private static final Logger logger = LogManager.getLogger(ArrayFileReaderServiceImpl.class);

    private final ArrayLineValidator validator;
    private final ArrayLineParser parser;
    private final ArrayFactory factory;

    public ArrayFileReaderServiceImpl(ArrayLineValidator validator,
                                      ArrayLineParser parser,
                                      ArrayFactory factory) {
        this.validator = validator;
        this.parser = parser;
        this.factory = factory;
    }

    @Override
    public List<ArrayWrapper<Integer>> readIntegerArrays(String filePath) {
        Path path = Paths.get(filePath);
        List<ArrayWrapper<Integer>> result = new ArrayList<>();
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException exception) {
            logger.error("Cannot read file: {}", filePath, exception);
            throw new ArrayProcessingException("Cannot read file: " + filePath, exception);
        }
        for (String line : lines) {
            if (!validator.isValid(line)) {
                logger.warn("Invalid line skipped: '{}'", line);
                continue;
            }
            if (line.trim().isEmpty()) {
                logger.info("Empty line skipped");
                continue;
            }
            try {
                Integer[] parsed = parser.parseToIntegerArray(line);
                result.add(factory.createIntegerArray(parsed));
            } catch (NumberFormatException exception) {
                logger.warn("Cannot parse line: '{}'", line, exception);
            }
        }
        logger.info("Read {} arrays from file {}", result.size(), filePath);
        return result;
    }
}