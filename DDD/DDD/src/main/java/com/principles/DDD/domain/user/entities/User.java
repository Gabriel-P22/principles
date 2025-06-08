package com.principles.DDD.domain.user.entities;

import com.principles.DDD.infrastructure.exception.MissingParamsException;
import com.principles.DDD.infrastructure.user.database.model.UserEntity;
import com.principles.DDD.presentation.user.dtos.UserRequest;
import com.principles.DDD.presentation.user.dtos.UserResponse;

public class User {
    private final String name;
    private final String email;
    private final String password;

    public User(final UserEntity requestEntity) throws Exception {
        this.name = requestEntity.getName();
        this.email = requestEntity.getEmail();
        this.password = requestEntity.getPassword();

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

    public UserResponse toResponse() {
        return new UserResponse(
                this.name,
                this.email,
                this.password
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
