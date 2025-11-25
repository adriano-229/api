package com.example.server.domain.exception;

public class BrandNullException extends RuntimeException {
    public BrandNullException() {
        super("Brand field can not be null");
    }
}