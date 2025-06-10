package com.principles.DDD.presentation.user.dtos;

public record AddressResponse(
        String street,
        String number,
        String zipcode,
        String city
) {
}
