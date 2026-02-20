package com.example.rover.core.applesauce;

public class NoSuchRoverException extends RuntimeException {
    public NoSuchRoverException(String message) {
        super(message);
    }
}
