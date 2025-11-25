package com.example.client.persistence.rest;

import com.example.client.domain.dto.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductRestDAO extends BaseRestDAO<ProductDTO, Long> {

    public ProductRestDAO(RestTemplate restTemplate) {
        super(restTemplate,
                "/products",
                ProductDTO.class,
                new ParameterizedTypeReference<>() {
                });
    }
}

