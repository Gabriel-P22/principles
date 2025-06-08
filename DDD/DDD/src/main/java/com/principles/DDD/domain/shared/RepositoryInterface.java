package com.principles.DDD.domain.shared;

import java.util.List;

public interface RepositoryInterface<T> {
    public void create(T domainEntity) throws Exception;
    public void update(String id, T domainEntity) throws Exception;
    public void delete(String id) throws Exception;
    public T find(String id) throws Exception;
    public List<T> findAll();
}
