package com.example.client.service;

import com.example.client.domain.dto.CategoryDTO;
import com.example.client.persistence.rest.CategoryRestDAO;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends RestCrudService<CategoryDTO, Long> {

    public CategoryService(CategoryRestDAO categoryRestDAO) {
        super(categoryRestDAO);
    }
}
