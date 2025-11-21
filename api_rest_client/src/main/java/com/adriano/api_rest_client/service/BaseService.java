package com.adriano.api_rest_client.service;

import com.adriano.api_rest_client.domain.dto.BaseDTO;
import com.adriano.api_rest_client.persistence.rest.BaseRestDAO;

import java.util.List;
import java.util.Optional;

public class BaseService<T extends BaseDTO, ID> implements CrudHooks<T, ID> {

    protected final BaseRestDAO<T, ID> baseRestDAO;

    public BaseService(BaseRestDAO<T, ID> baseRestDAO) {
        this.baseRestDAO = baseRestDAO;
    }

    public List<T> list() {
        return baseRestDAO.list();
    }

    public Optional<T> get(ID id) {
        beforeRead(id);
        Optional<T> entity = Optional.ofNullable(baseRestDAO.get(id));
        entity.ifPresent(this::afterRead);
        return entity;
    }

    public void update(ID id, T newEntity) {
        beforeUpdate(id, newEntity);
        baseRestDAO.get(id).map(existing -> {
            newEntity.setId(existing.getId());
            T updated = baseRestDAO.save(newEntity);
            afterUpdate(updated);
            return updated;
        }).orElse(null);
    }

    public void delete(ID id) {
        beforeDelete(id);
        baseRestDAO.get(id).ifPresent(e -> {
            baseRepository.deleteById(id);
            afterDelete(id);
        });
    }


    @Override
    public void beforeCreate(BaseDTO entity) {

    }

    @Override
    public void afterCreate(BaseDTO entity) {

    }

    @Override
    public void beforeRead(Long aLong) {

    }

    @Override
    public void afterRead(BaseDTO entity) {

    }

    @Override
    public void beforeUpdate(Long aLong, BaseDTO entity) {

    }

    @Override
    public void afterUpdate(BaseDTO entity) {

    }

    @Override
    public void beforeDelete(Long aLong) {

    }

    @Override
    public void afterDelete(Long aLong) {

    }

    @Override
    public void beforeRead(ID id) {

    }

    @Override
    public void beforeUpdate(ID id, T entity) {

    }

    @Override
    public void beforeDelete(ID id) {

    }

    @Override
    public void afterDelete(ID id) {

    }
}
