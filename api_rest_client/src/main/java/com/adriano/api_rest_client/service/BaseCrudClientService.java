package com.adriano.api_rest_client.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class BaseCrudClientService<T, ID, DAO> implements CrudClientService<T, ID> {

    protected final DAO dao;

    protected BaseCrudClientService(DAO dao) {
        this.dao = dao;
    }

    protected abstract List<T> doList();

    protected abstract Optional<T> doFindById(ID id);

    protected abstract T doCreate(T entity);

    protected abstract T doUpdate(ID id, T entity);

    protected abstract void doDelete(ID id);

    @Override
    public List<T> findAll() {
        return doList();
    }

    @Override
    public Optional<T> findById(ID id) {
        return doFindById(id);
    }

    @Override
    public T create(T entity) {
        return doCreate(entity);
    }

    @Override
    public T update(ID id, T entity) {
        return doUpdate(id, entity);
    }

    @Override
    public void delete(ID id) {
        doDelete(id);
    }
}

