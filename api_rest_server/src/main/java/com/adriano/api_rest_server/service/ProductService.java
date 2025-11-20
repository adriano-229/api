package com.adriano.api_rest_server.service;

import com.adriano.api_rest_server.domain.entity.Product;
import com.adriano.api_rest_server.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<Product, Long> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    public void nullifyCategory(Long categoryId) {
        List<Product> affected = productRepository.findByCategoryId(categoryId);
        affected.forEach(product -> {
            product.setCategory(null);
            productRepository.save(product);
        });
    }

    public void nullifyBrand(Long brandId) {
        List<Product> affected = productRepository.findByBrandId(brandId);
        affected.forEach(product -> {
            product.setBrand(null);
            productRepository.save(product);
        });
    }
}