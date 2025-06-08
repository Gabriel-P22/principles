package com.principles.DDD.infrastructure.exception;

public class ConflictExceptions extends RuntimeException {
    public ConflictExceptions(final String message) {
        super(message);
    }
}
