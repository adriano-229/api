package com.adriano.api_rest_client.persistence.rest;

import com.adriano.api_rest_client.domain.dto.BrandDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

