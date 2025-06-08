package com.principles.DDD.domain.shared;

import java.util.List;

public interface RepositoryInterface<T> {
    public void create(final T domainEntity) throws Exception;
    public void update(final String id, T domainEntity) throws Exception;
    public void delete(final String id) throws Exception;
    public T find(final String id) throws Exception;
    public List<T> findAll();
}
