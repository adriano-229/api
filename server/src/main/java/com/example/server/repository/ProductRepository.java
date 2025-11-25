package com.example.server.repository;

import com.example.server.domain.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {

    List<Product> findByBrandId(Long brandId);
}
