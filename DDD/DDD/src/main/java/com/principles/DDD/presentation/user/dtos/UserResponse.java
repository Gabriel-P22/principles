package com.principles.DDD.presentation.user.dtos;

public record UserResponse(
        String name,
        String email,
        String password
) {}
