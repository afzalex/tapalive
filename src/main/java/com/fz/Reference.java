package com.fz;


public class Reference<T> {
    private T item;
    Reference(T item) {
        this.item = item;
    }

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}
