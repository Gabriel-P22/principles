package com.principles.DDD.infrastructure.user.database.repository;

import com.principles.DDD.infrastructure.user.database.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, String> {
}
