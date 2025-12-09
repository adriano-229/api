package com.example.client.service;

import com.example.client.domain.dto.BaseDto;
import com.example.client.persistence.rest.BaseRestDao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseDto, ID extends Serializable> {

    protected final BaseRestDao<T, ID> restDAO;

    protected BaseService(BaseRestDao<T, ID> restDAO) {
        this.restDAO = restDAO;
    }

    public List<T> findAll() {
        return restDAO.list();
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(restDAO.get(id));
    }

    public T create(T entity) {
        return restDAO.create(entity);
    }

    public T update(ID id, T entity) {
        return restDAO.update(id, entity);
    }

    public void deleteById(ID id) {
        restDAO.delete(id);
    }
}

