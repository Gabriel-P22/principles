package com.principles.DDD.presentation.user.dtos;

public record UserRequest(
        String name,
        String email,
        String password
) {}
