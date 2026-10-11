package com.example.arrays.service;

import com.example.arrays.entity.ArrayWrapper;

import java.util.Optional;

public interface ArrayCalculationService {
    Optional<Integer> findMin(ArrayWrapper<Integer> array);
    Optional<Integer> findMax(ArrayWrapper<Integer> array);
    Optional<Long> findSum(ArrayWrapper<Integer> array);
    Optional<Double> findAverage(ArrayWrapper<Integer> array);
}