package com.fz;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class IgnorableReference<T> {

    private LocalTime ignoranceTime;
    private final static int IGNORANCE_TIME = 1000;
    private T item;

    IgnorableReference(T item) {
        this.item = item;
    }

    public void set(T item) {
        if (ignoranceTime != null && ChronoUnit.MILLIS.between(ignoranceTime, LocalTime.now()) > IGNORANCE_TIME) {
            this.item = item;
        }
    }

    public T get() {
        return item;
    }

    public void ignoreForSometime() {
        ignoranceTime = LocalTime.now();
    }
}
