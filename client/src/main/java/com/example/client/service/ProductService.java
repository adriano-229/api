package com.example.client.service;

import com.example.client.domain.dto.ProductDto;
import com.example.client.persistence.rest.ProductRestDao;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<ProductDto, Long> {

    public ProductService(ProductRestDao productRestDAO) {
        super(productRestDAO);
    }
}
