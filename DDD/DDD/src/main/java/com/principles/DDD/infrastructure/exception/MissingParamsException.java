package com.principles.DDD.infrastructure.exception;

public class MissingParamsException extends RuntimeException {
    public MissingParamsException(final String message) {
        super(message);
    }
}
