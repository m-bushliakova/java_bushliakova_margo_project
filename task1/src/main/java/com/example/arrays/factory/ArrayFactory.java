package com.example.arrays.factory;

import com.example.arrays.entity.ArrayWrapper;

public interface ArrayFactory {
    ArrayWrapper<Integer> createIntegerArray(Integer[] elements);
    ArrayWrapper<Double> createDoubleArray(Double[] elements);
}