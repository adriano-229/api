package com.example.server.service;

import com.example.server.domain.entity.BaseEntity;
import com.example.server.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity, ID> implements CrudHooks<T, ID> {

    protected final BaseRepository<T, ID> baseRepository;

    public BaseService(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public Optional<T> findById(ID id) {
        beforeRead(id);
        Optional<T> entity = baseRepository.findById(id);
        entity.ifPresent(this::afterRead);
        return entity;
    }

    public T save(T entity) {
        beforeCreate(entity);
        T saved = baseRepository.save(entity);
        afterCreate(saved);
        return saved;
    }

    public T update(ID id, T newEntity) {
        beforeUpdate(id, newEntity);
        return baseRepository.findById(id).map(existing -> {
            newEntity.setId(existing.getId());
            T updated = baseRepository.save(newEntity);
            afterUpdate(updated);
            return updated;
        }).orElse(null);
    }

    public void deleteById(ID id) {
        beforeDelete(id);
        baseRepository.findById(id).ifPresent(e -> {
            baseRepository.deleteById(id);
            afterDelete(id);
        });
    }
}
