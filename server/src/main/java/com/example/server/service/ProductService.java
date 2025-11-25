package com.example.server.service;

import com.example.server.domain.entity.Product;
import com.example.server.domain.exception.BrandNotFoundException;
import com.example.server.domain.exception.BrandNullException;
import com.example.server.repository.BrandRepository;
import com.example.server.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<Product, Long> {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductService(ProductRepository productRepository, BrandRepository brandRepository) {
        super(productRepository);
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
    }

    public void nullifyBrand(Long brandId) {
        List<Product> affected = productRepository.findByBrandId(brandId);
        affected.forEach(product -> {
            product.setBrand(null);
            productRepository.save(product);
        });
    }

    @Override
    public void beforeCreate(Product entity) {
        Long brandId = entity.getBrand().getId();
        if (brandId == null) {
            throw new BrandNullException();
        }
        if (!brandRepository.existsById(brandId)) {
            throw new BrandNotFoundException(brandId);
        }
    }
}