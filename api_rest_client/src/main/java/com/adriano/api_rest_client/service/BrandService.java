package com.adriano.api_rest_client.service;

import com.adriano.api_rest_client.domain.dto.BrandDTO;
import com.adriano.api_rest_client.persistence.rest.BrandRestDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements CrudClientService<BrandDTO, Long> {

    private final BrandRestDAO brandRestDAO;

    public BrandService(BrandRestDAO brandRestDAO) {
        this.brandRestDAO = brandRestDAO;
    }

    @Override
    public List<BrandDTO> findAll() {
        return brandRestDAO.list();
    }

    @Override
    public Optional<BrandDTO> findById(Long id) {
        return Optional.ofNullable(brandRestDAO.get(id));
    }

    @Override
    public BrandDTO create(BrandDTO entity) {
        return brandRestDAO.create(entity);
    }

    @Override
    public BrandDTO update(Long id, BrandDTO entity) {
        return brandRestDAO.update(id, entity);
    }

    @Override
    public void delete(Long id) {
        brandRestDAO.delete(id);
    }
}

