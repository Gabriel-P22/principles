package com.principles.DDD.domain.user.vo;

import com.principles.DDD.infrastructure.user.database.model.AddressEntity;
import com.principles.DDD.presentation.user.dtos.AddressRequest;
import com.principles.DDD.presentation.user.dtos.AddressResponse;

public class Address {
    private final String street;
    private final String number;
    private final String zipcode;
    private final String city;

    public Address(AddressRequest addressRequest) {
        this.street = addressRequest.street();
        this.number = addressRequest.number();
        this.zipcode = addressRequest.zipcode();
        this.city = addressRequest.city();
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public AddressEntity toModel() {
        return new AddressEntity(street, number, zipcode, city);
    }

    public AddressResponse toResponse() {
        return new AddressResponse(
                street,
                number,
                zipcode,
                city
        );
    }
}
