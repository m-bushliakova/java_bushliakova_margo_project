package com.example.arrays.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.arrays.entity.ArrayWrapper;
import com.example.arrays.service.ArraySortService;

public class ArraySortServiceImpl implements ArraySortService {

    private static final Logger logger = LogManager.getLogger(ArraySortServiceImpl.class);

    @Override
    public void bubbleSort(ArrayWrapper<Integer> array) {
        Integer[] elements = array.getElements();
        int length = elements.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
        array.setElements(elements);
        logger.info("Bubble sort completed. Result: {}", java.util.Arrays.toString(elements));
    }

    @Override
    public void quickSort(ArrayWrapper<Integer> array) {
        Integer[] elements = array.getElements();
        quickSort(elements, 0, elements.length - 1);
        array.setElements(elements);
        logger.info("Quick sort completed. Result: {}", java.util.Arrays.toString(elements));
    }

    private void quickSort(Integer[] elements, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(elements, low, high);
            quickSort(elements, low, pivotIndex - 1);
            quickSort(elements, pivotIndex + 1, high);
        }
    }

    private int partition(Integer[] elements, int low, int high) {
        int pivot = elements[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (elements[j] <= pivot) {
                i++;
                int temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
            }
        }
        int temp = elements[i + 1];
        elements[i + 1] = elements[high];
        elements[high] = temp;
        return i + 1;
    }
}