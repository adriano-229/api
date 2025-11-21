package com.adriano.api_rest_server.repository;

import com.adriano.api_rest_server.domain.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByBrandId(Long brandId);
}
