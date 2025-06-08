package com.principles.DDD.infrastructure.exception;

public class ConflictExceptions extends RuntimeException {
    public ConflictExceptions(String message) {
        super(message);
    }
}
