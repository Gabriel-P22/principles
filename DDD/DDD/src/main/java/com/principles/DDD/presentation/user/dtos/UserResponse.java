package com.principles.DDD.presentation.user.dtos;

import java.util.Optional;

public record UserResponse(
        String name,
        String email,
        String password,
        Optional<AddressResponse> address
) {}
