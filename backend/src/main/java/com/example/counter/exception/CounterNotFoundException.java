package com.example.counter.exception;

public class CounterNotFoundException extends RuntimeException {
    public CounterNotFoundException() {
        super("Counter not found");
    }
}
