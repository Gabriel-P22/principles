package com.principles.DDD.infrastructure.user.database.repository;

import com.principles.DDD.domain.user.entities.User;
import com.principles.DDD.domain.user.respository.UserRepositoryInterface;
import com.principles.DDD.infrastructure.exception.ConflictExceptions;
import com.principles.DDD.infrastructure.exception.NotFoundException;
import com.principles.DDD.infrastructure.user.database.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRepositoryOrchestrator implements UserRepositoryInterface {

    private final UserRepository repository;

    public UserRepositoryOrchestrator(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(final User domainEntity) {
        if (repository.existsByEmail(domainEntity.getEmail())) {
            throw new ConflictExceptions("Use another email");
        }

        repository.save(new UserEntity(domainEntity));
    }

    @Override
    public void update(final String id, final User domainEntity) {
        final UserEntity entity  = this.findById(id);
        entity.setName(domainEntity.getName())
                .setEmail(domainEntity.getEmail())
                .setPassword(domainEntity.getPassword());

        repository.save(entity);
    }

    @Override
    public void delete(final String id) {
        final UserEntity entity = findById(id);
        repository.delete(entity);
    }

    @Override
    public User find(final String id) throws Exception {
        return new User(this.findById(id));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream().map(entity -> {
            try {
                return new User(entity);
            } catch (Exception e) {
                throw new NotFoundException("User missing values");
            }
        }).collect(Collectors.toList());
    }

    private UserEntity findById(final String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }
}
