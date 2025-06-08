package com.principles.DDD.infrastructure.exception.dto;

import java.time.LocalDateTime;

public record ExceptionResponse(
        LocalDateTime timestamp,
        int status,
        String message,
        String path
) {
}
