package com.principles.DDD.domain.user.entities;

import com.principles.DDD.domain.user.vo.Address;
import com.principles.DDD.infrastructure.exception.MissingParamsException;
import com.principles.DDD.infrastructure.user.database.model.UserEntity;
import com.principles.DDD.presentation.user.dtos.AddressRequest;
import com.principles.DDD.presentation.user.dtos.AddressResponse;
import com.principles.DDD.presentation.user.dtos.UserRequest;
import com.principles.DDD.presentation.user.dtos.UserResponse;

import java.util.Optional;

public class User {
    private final String name;
    private final String email;
    private final String password;
    private Address address;

    public User(final UserEntity userEntity) throws Exception {
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();

        this.validation();
    }

    public User(final UserRequest requestEntity) throws Exception {
        this.name = requestEntity.name();
        this.email = requestEntity.email();
        this.password = requestEntity.password();

        this.validation();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    public UserResponse toResponse() {
        AddressResponse addressResponse = address != null ? address.toResponse() : null;
        return new UserResponse(
                this.name,
                this.email,
                this.password,
                Optional.ofNullable(addressResponse)
        );
    }

    private void validation() throws Exception {
        if (this.name == null || this.name.isEmpty()) {
            throw new MissingParamsException("name is required");
        }

        if (this.email == null ||this.email.isEmpty()) {
            throw new MissingParamsException("email is required");
        }

        if (this.password == null ||this.password.isEmpty()) {
            throw new MissingParamsException("password is required");
        }
    }
}
