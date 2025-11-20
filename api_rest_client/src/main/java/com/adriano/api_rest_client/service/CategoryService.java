package com.adriano.api_rest_client.service;

import com.adriano.api_rest_client.domain.dto.CategoryDTO;
import com.adriano.api_rest_client.persistence.rest.CategoryRestDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/*
Service class for managing categories business logic via REST API.
 */
@Service
public class CategoryService implements CrudClientService<CategoryDTO, Long> {

    private final CategoryRestDAO categoryRestDAO;

    public CategoryService(CategoryRestDAO categoryRestDAO) {
        this.categoryRestDAO = categoryRestDAO;
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRestDAO.list();
    }

    @Override
    public Optional<CategoryDTO> findById(Long id) {
        return Optional.ofNullable(categoryRestDAO.get(id));
    }

    @Override
    public CategoryDTO create(CategoryDTO entity) {
        return categoryRestDAO.create(entity);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO entity) {
        return categoryRestDAO.update(id, entity);
    }

    @Override
    public void delete(Long id) {
        categoryRestDAO.delete(id);
    }
}
