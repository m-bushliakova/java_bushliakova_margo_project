package com.example.arrays.service;

import com.example.arrays.entity.ArrayWrapper;

public interface ArraySortService {
    void bubbleSort(ArrayWrapper<Integer> array);
    void quickSort(ArrayWrapper<Integer> array);
}