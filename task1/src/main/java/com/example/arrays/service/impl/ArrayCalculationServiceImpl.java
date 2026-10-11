package com.example.arrays.service.impl;

import com.example.arrays.entity.ArrayWrapper;
import com.example.arrays.service.ArrayCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {

    private static final Logger logger = LogManager.getLogger(ArrayCalculationServiceImpl.class);

    @Override
    public Optional<Integer> findMin(ArrayWrapper<Integer> array) {
        Integer[] elements = array.getElements();
        if (elements.length == 0) {
            logger.warn("Attempt to find min in empty array");
            return Optional.empty();
        }
        Integer min = elements[0];
        for (Integer element : elements) {
            if (element < min) {
                min = element;
            }
        }
        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findMax(ArrayWrapper<Integer> array) {
        Integer[] elements = array.getElements();
        if (elements.length == 0) {
            logger.warn("Attempt to find max in empty array");
            return Optional.empty();
        }
        Integer max = elements[0];
        for (Integer element : elements) {
            if (element > max) {
                max = element;
            }
        }
        return Optional.of(max);
    }

    @Override
    public Optional<Long> findSum(ArrayWrapper<Integer> array) {
        Integer[] elements = array.getElements();
        if (elements.length == 0) {
            logger.warn("Attempt to find sum in empty array");
            return Optional.empty();
        }
        long sum = 0L;
        for (Integer element : elements) {
            sum += element;
        }
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> findAverage(ArrayWrapper<Integer> array) {
        Optional<Long> sumOptional = findSum(array);
        if (sumOptional.isEmpty()) {
            return Optional.empty();
        }
        long sum = sumOptional.get();
        double average = (double) sum / array.size();
        return Optional.of(average);
    }
}