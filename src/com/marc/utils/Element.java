package com.marc.utils;

public class Element<T> {
    public T value;
    public Element<T> next = null;
    public Element<T> prev = null;

    public Element(T value) {
        this.value = value;
    }
}
