package com.example.client.service;

import com.example.client.domain.dto.BrandDto;
import com.example.client.persistence.rest.BrandRestDao;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends BaseService<BrandDto, Long> {

    public BrandService(BrandRestDao brandRestDAO) {
        super(brandRestDAO);
    }
}
