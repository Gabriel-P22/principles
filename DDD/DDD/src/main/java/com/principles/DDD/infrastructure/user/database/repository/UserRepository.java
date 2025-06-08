package com.principles.DDD.infrastructure.user.database.repository;

import com.principles.DDD.infrastructure.user.database.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByEmail(final String email);
}
