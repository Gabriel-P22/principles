package com.principles.DDD.application.user.handlers;

import com.principles.DDD.domain.user.entities.User;
import com.principles.DDD.domain.user.factory.UserFactory;
import com.principles.DDD.domain.user.respository.UserRepositoryInterface;
import com.principles.DDD.presentation.user.dtos.UserRequest;
import com.principles.DDD.presentation.user.dtos.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindUserHandler {
    private final UserRepositoryInterface repository;

    public FindUserHandler(final UserRepositoryInterface repository) {
        this.repository = repository;
    }

    public UserResponse find(final String id) throws Exception {
        return repository.find(id).toResponse();
    }

    public List<UserResponse> findAll() throws Exception {
        return repository.findAll().stream().map(User::toResponse).toList();
    }
}