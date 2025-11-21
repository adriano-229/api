package com.adriano.api_rest_server.service;

import com.adriano.api_rest_server.domain.entity.Category;
import com.adriano.api_rest_server.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category, Long> {

    private final ProductService productService;

    public CategoryService(BaseRepository<Category, Long> repository, ProductService productService) {
        super(repository);
        this.productService = productService;
    }

    @Override
    public void beforeDelete(Long id) {
        productService.nullifyCategory(id);
    }
}