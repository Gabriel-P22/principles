package com.principles.DDD.application.user.handlers;

import com.principles.DDD.domain.user.entities.User;
import com.principles.DDD.domain.user.factory.UserFactory;
import com.principles.DDD.domain.user.respository.UserRepositoryInterface;
import com.principles.DDD.presentation.user.dtos.UserRequest;
import com.principles.DDD.presentation.user.dtos.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateANewUserHandler {
    private final UserRepositoryInterface repository;

    public CreateANewUserHandler(final UserRepositoryInterface repository) {
        this.repository = repository;
    }

    public UserResponse createANewUser(final UserRequest requestEntity) throws Exception {
        final User domainEntity = UserFactory.create(requestEntity);
        repository.create(domainEntity);
        return domainEntity.toResponse();
    }
}
