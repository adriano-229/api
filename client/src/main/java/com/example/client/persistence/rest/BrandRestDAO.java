package com.example.client.persistence.rest;

import com.example.client.domain.dto.BrandDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BrandRestDAO extends BaseRestDAO<BrandDTO, Long> {

    public BrandRestDAO(RestTemplate restTemplate) {
        super(restTemplate,
                "/brands",
                BrandDTO.class,
                new ParameterizedTypeReference<>() {
                });
    }
}

