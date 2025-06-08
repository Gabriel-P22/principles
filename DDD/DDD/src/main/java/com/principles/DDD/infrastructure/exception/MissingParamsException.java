package com.principles.DDD.infrastructure.exception;

public class MissingParamsException extends RuntimeException {
    public MissingParamsException(String message) {
        super(message);
    }
}
