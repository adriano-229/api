package com.example.client.service;

import com.example.client.domain.dto.ProductDTO;
import com.example.client.persistence.rest.ProductRestDAO;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends RestCrudService<ProductDTO, Long> {

    public ProductService(ProductRestDAO productRestDAO) {
        super(productRestDAO);
    }
}
