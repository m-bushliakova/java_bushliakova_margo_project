package com.example.arrays.runner;

import com.example.arrays.entity.ArrayWrapper;
import com.example.arrays.factory.ArrayFactory;
import com.example.arrays.factory.ArrayWrapperFactory;
import com.example.arrays.parser.ArrayLineParser;
import com.example.arrays.parser.impl.ArrayLineParserImpl;
import com.example.arrays.service.ArrayCalculationService;
import com.example.arrays.service.ArrayFileReaderService;
import com.example.arrays.service.ArraySortService;
import com.example.arrays.service.impl.ArrayCalculationServiceImpl;
import com.example.arrays.service.impl.ArrayFileReaderServiceImpl;
import com.example.arrays.service.impl.ArraySortServiceImpl;
import com.example.arrays.validator.ArrayLineValidator;
import com.example.arrays.validator.impl.ArrayLineValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ApplicationRunner {

    private static final Logger logger = LogManager.getLogger(ApplicationRunner.class);
    private static final String DATA_FILE = "data/arrays.txt";

    public static void main(String[] args) {
        ArrayLineValidator validator = new ArrayLineValidatorImpl();
        ArrayLineParser parser = new ArrayLineParserImpl();
        ArrayFactory factory = new ArrayWrapperFactory();
        ArrayFileReaderService readerService =
                new ArrayFileReaderServiceImpl(validator, parser, factory);
        ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();

        List<ArrayWrapper<Integer>> arrays = readerService.readIntegerArrays(DATA_FILE);
        for (ArrayWrapper<Integer> array : arrays) {
            logger.info("Array: {}", array);
            calculationService.findMin(array).ifPresent(min -> logger.info("Min: {}", min));
            calculationService.findMax(array).ifPresent(max -> logger.info("Max: {}", max));
            calculationService.findSum(array).ifPresent(sum -> logger.info("Sum: {}", sum));
            calculationService.findAverage(array).ifPresent(avg -> logger.info("Avg: {}", avg));
            sortService.bubbleSort(array);
            sortService.quickSort(array);
        }
    }
}