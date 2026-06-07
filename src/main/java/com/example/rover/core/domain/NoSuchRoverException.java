package com.example.rover.core.domain;

public class NoSuchRoverException extends RuntimeException {
    public NoSuchRoverException(String message) {
        super(message);
    }
}
