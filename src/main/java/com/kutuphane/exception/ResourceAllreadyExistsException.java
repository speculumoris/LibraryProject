package com.kutuphane.exception;

public class ResourceAllreadyExistsException extends RuntimeException {
    public ResourceAllreadyExistsException(String message) {
        super(message);
    }
}
