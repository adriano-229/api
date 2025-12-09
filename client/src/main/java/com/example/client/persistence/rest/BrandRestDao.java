package com.example.client.persistence.rest;

import com.example.client.domain.dto.BrandDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BrandRestDao extends BaseRestDao<BrandDto, Long> {

    public BrandRestDao(RestTemplate restTemplate) {
        super(restTemplate,
                "/brands",
                BrandDto.class,
                new ParameterizedTypeReference<>() {
                });
    }
}

