package com.adriano.api_rest_client.service;

import com.adriano.api_rest_client.domain.dto.ProductDTO;
import com.adriano.api_rest_client.persistence.rest.ProductRestDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements CrudHooks<ProductDTO, Long> {

    private final ProductRestDAO productRestDAO;

    public ProductService(ProductRestDAO productRestDAO) {
        this.productRestDAO = productRestDAO;
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRestDAO.list();
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return Optional.ofNullable(productRestDAO.get(id));
    }

    @Override
    public ProductDTO create(ProductDTO entity) {
        return productRestDAO.create(entity);
    }

    @Override
    public void update(Long id, ProductDTO entity) {
        productRestDAO.update(id, entity);
    }

    @Override
    public void delete(Long id) {
        productRestDAO.delete(id);
    }
}

