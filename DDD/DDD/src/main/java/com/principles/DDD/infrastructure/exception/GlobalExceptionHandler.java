package com.principles.DDD.infrastructure.exception;

import com.principles.DDD.infrastructure.exception.dto.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ExceptionResponse notFound(final Exception exception, final HttpServletRequest request) {
        return new ExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                request.getServletPath()
        );
    }

    @ExceptionHandler(MissingParamsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse missingParams(final Exception exception, final HttpServletRequest request) {
        return new ExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                request.getServletPath()
        );
    }

    @ExceptionHandler(ConflictExceptions.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse conflict(final Exception exception, final HttpServletRequest request) {
        return new ExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                exception.getMessage(),
                request.getServletPath()
        );
    }
}
