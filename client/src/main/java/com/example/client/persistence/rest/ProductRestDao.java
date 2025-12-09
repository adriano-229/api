package com.example.client.persistence.rest;

import com.example.client.domain.dto.ProductDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductRestDao extends BaseRestDao<ProductDto, Long> {

    public ProductRestDao(RestTemplate restTemplate) {
        super(restTemplate,
                "/products",
                ProductDto.class,
                new ParameterizedTypeReference<>() {
                });
    }
}

