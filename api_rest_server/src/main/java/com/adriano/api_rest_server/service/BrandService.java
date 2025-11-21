package com.adriano.api_rest_server.service;

import com.adriano.api_rest_server.domain.entity.Brand;
import com.adriano.api_rest_server.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends BaseService<Brand, Long> {

    private final ProductService productService;

    public BrandService(BaseRepository<Brand, Long> repository, ProductService productService) {
        super(repository);
        this.productService = productService;
    }

    @Override
    public void beforeDelete(Long id) {
        productService.nullifyBrand(id);
    }
}