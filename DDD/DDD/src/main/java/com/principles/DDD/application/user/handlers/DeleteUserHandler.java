package com.principles.DDD.application.user.handlers;

import com.principles.DDD.domain.user.entities.User;
import com.principles.DDD.domain.user.factory.UserFactory;
import com.principles.DDD.domain.user.respository.UserRepositoryInterface;
import com.principles.DDD.presentation.user.dtos.UserRequest;
import com.principles.DDD.presentation.user.dtos.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserHandler {
    private final UserRepositoryInterface repository;

    public DeleteUserHandler(final UserRepositoryInterface repository) {
        this.repository = repository;
    }

    public void delete(final String id) throws Exception {
        repository.delete(id);
    }
}
