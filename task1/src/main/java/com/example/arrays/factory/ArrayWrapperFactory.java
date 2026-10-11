package com.example.arrays.factory;

import com.example.arrays.entity.ArrayWrapper;
import com.example.arrays.entity.DoubleArrayWrapper;
import com.example.arrays.entity.IntegerArrayWrapper;

public class ArrayWrapperFactory implements ArrayFactory {

    @Override
    public ArrayWrapper<Integer> createIntegerArray(Integer[] elements) {
        return new IntegerArrayWrapper(elements);
    }

    @Override
    public ArrayWrapper<Double> createDoubleArray(Double[] elements) {
        return new DoubleArrayWrapper(elements);
    }
}