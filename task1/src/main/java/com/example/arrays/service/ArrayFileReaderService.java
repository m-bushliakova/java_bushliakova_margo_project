package com.example.arrays.service;

import com.example.arrays.entity.ArrayWrapper;

import java.util.List;

public interface ArrayFileReaderService {
    List<ArrayWrapper<Integer>> readIntegerArrays(String filePath);
}