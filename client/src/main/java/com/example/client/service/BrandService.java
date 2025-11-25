package com.example.client.service;

import com.example.client.domain.dto.BrandDTO;
import com.example.client.persistence.rest.BrandRestDAO;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends RestCrudService<BrandDTO, Long> {

    public BrandService(BrandRestDAO brandRestDAO) {
        super(brandRestDAO);
    }
}
