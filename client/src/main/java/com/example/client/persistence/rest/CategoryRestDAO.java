package com.example.client.persistence.rest;

import com.example.client.domain.dto.CategoryDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CategoryRestDAO extends BaseRestDAO<CategoryDTO, Long> {

    public CategoryRestDAO(RestTemplate restTemplate) {
        super(restTemplate,
                "/categories",
                CategoryDTO.class,
                new ParameterizedTypeReference<>() {
                });
    }
}
