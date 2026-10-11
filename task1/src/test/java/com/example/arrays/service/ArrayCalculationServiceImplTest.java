package com.example.arrays.service;

import com.example.arrays.entity.ArrayWrapper;
import com.example.arrays.entity.IntegerArrayWrapper;
import com.example.arrays.service.impl.ArrayCalculationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayCalculationServiceImplTest {

    private static final Integer[] ELEMENTS = {5, 3, 9, 1, 7};
    private static final Integer EXPECTED_MIN = 1;
    private static final Integer EXPECTED_MAX = 9;
    private static final Long EXPECTED_SUM = 25L;
    private static final Double EXPECTED_AVERAGE = 5.0;

    private ArrayCalculationService service;
    private ArrayWrapper<Integer> array;

    @BeforeEach
    void setUp() {
        service = new ArrayCalculationServiceImpl();
        array = new IntegerArrayWrapper(ELEMENTS);
    }

    @Test
    void findMinShouldReturnMinValue() {
        Optional<Integer> actual = service.findMin(array);
        assertEquals(Optional.of(EXPECTED_MIN), actual);
    }

    @Test
    void findMaxShouldReturnMaxValue() {
        Optional<Integer> actual = service.findMax(array);
        assertEquals(Optional.of(EXPECTED_MAX), actual);
    }

    @Test
    void findSumShouldReturnSum() {
        Optional<Long> actual = service.findSum(array);
        assertEquals(Optional.of(EXPECTED_SUM), actual);
    }

    @Test
    void findAverageShouldReturnAverage() {
        Optional<Double> actual = service.findAverage(array);
        assertEquals(Optional.of(EXPECTED_AVERAGE), actual);
    }

    @Test
    void findMinShouldReturnEmptyForEmptyArray() {
        ArrayWrapper<Integer> emptyArray = new IntegerArrayWrapper(new Integer[0]);
        Optional<Integer> actual = service.findMin(emptyArray);
        assertEquals(Optional.empty(), actual);
    }
}