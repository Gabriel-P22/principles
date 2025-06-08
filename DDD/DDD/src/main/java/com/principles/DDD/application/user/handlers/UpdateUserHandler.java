package com.principles.DDD.application.user.handlers;

import com.principles.DDD.domain.user.entities.User;
import com.principles.DDD.domain.user.factory.UserFactory;
import com.principles.DDD.domain.user.respository.UserRepositoryInterface;
import com.principles.DDD.infrastructure.user.database.model.UserEntity;
import com.principles.DDD.presentation.user.dtos.UserRequest;
import com.principles.DDD.presentation.user.dtos.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateUserHandler {
    private final UserRepositoryInterface repository;

    public UpdateUserHandler(final UserRepositoryInterface repository) {
        this.repository = repository;
    }

    public UserResponse update(final String id, final UserRequest requestEntity) throws Exception {
        User domainEntity = UserFactory.create(requestEntity);
        repository.update(id, domainEntity);
        return domainEntity.toResponse();
    }
}