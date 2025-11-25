package com.example.server.domain.exception;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(Long brandId) {
        super("Brand not found: " + brandId);
    }
}