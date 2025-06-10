package com.principles.DDD.presentation.user.dtos;

public record AddressRequest(
        String street,
        String number,
        String zipcode,
        String city
) {
}
