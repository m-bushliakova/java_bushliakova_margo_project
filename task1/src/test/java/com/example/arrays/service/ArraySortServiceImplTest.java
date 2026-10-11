package com.example.arrays.service;

import com.example.arrays.entity.ArrayWrapper;
import com.example.arrays.entity.IntegerArrayWrapper;
import com.example.arrays.service.impl.ArraySortServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArraySortServiceImplTest {

    private static final Integer[] UNSORTED = {5, 3, 9, 1, 7};
    private static final Integer[] EXPECTED = {1, 3, 5, 7, 9};

    private ArraySortService service;

    @BeforeEach
    void setUp() {
        service = new ArraySortServiceImpl();
    }

    @Test
    void bubbleSortShouldSortArray() {
        ArrayWrapper<Integer> array = new IntegerArrayWrapper(UNSORTED.clone());
        service.bubbleSort(array);
        assertArrayEquals(EXPECTED, array.getElements());
    }

    @Test
    void quickSortShouldSortArray() {
        ArrayWrapper<Integer> array = new IntegerArrayWrapper(UNSORTED.clone());
        service.quickSort(array);
        assertArrayEquals(EXPECTED, array.getElements());
    }
}