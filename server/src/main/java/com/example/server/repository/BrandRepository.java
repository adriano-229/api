package com.example.server.repository;

import com.example.server.domain.entity.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends BaseRepository<Brand, Long> {
}
