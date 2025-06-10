package com.principles.DDD.application.user.handlers;

import com.principles.DDD.domain.user.entities.User;
import com.principles.DDD.domain.user.factory.UserFactory;
import com.principles.DDD.domain.user.respository.UserRepositoryInterface;
import com.principles.DDD.presentation.user.dtos.UserRequest;
import com.principles.DDD.presentation.user.dtos.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserHandler {

    private final UserRepositoryInterface repository;

    public UserHandler(final UserRepositoryInterface repository) {
        this.repository = repository;
    }

    public UserResponse create(final UserRequest requestEntity) throws Exception {
        User domainEntity;

        if (requestEntity.address().isPresent()) {
            domainEntity = UserFactory.create(requestEntity, requestEntity.address().get());
        } else {
            domainEntity = UserFactory.create(requestEntity);
        }

        repository.create(domainEntity);


        return domainEntity.toResponse();
    }

    public UserResponse update(final String id, final UserRequest requestEntity) throws Exception {
        User domainEntity = UserFactory.create(requestEntity);
        repository.update(id, domainEntity);
        return domainEntity.toResponse();
    }

    public void delete(final String id) throws Exception {
        repository.delete(id);
    }

    public UserResponse findById(String id) throws Exception {
        return repository.find(id).toResponse();
    }

    public List<UserResponse> findAll() throws Exception {
        return repository.findAll().stream().map(User::toResponse).toList();
    }
}
