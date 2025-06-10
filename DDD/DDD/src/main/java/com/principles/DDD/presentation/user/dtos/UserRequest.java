package com.principles.DDD.presentation.user.dtos;

import java.util.Optional;

public record UserRequest(
        String name,
        String email,
        String password,
        Optional<AddressRequest> address
) {}
