package com.example.arrays.entity;

import java.util.Arrays;

public abstract class ArrayWrapper<T> {

    protected T[] elements;

    protected ArrayWrapper(T[] elements) {
        this.elements = elements;
    }

    public T[] getElements() {
        return elements.clone();
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }

    public int size() {
        return elements.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArrayWrapper<?> other = (ArrayWrapper<?>) obj;
        return Arrays.equals(elements, other.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{elements=" + Arrays.toString(elements) + "}";
    }
}