package com.example.server.service;

public interface CrudHooks<T, ID> {

    default void beforeCreate(T entity) {
    }

    default void afterCreate(T entity) {
    }

    default void beforeRead(ID id) {
    }

    default void afterRead(T entity) {
    }

    default void beforeUpdate(ID id, T entity) {
    }

    default void afterUpdate(T entity) {
    }

    default void beforeDelete(ID id) {
    }

    default void afterDelete(ID id) {
    }
}
