package com.example.server.controller.view;

import com.example.server.domain.dto.BrandDto;
import com.example.server.domain.entity.Brand;
import com.example.server.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandController extends BaseController<Brand, BrandDto, Long> {

    public BrandController(BrandService brandService) {
        super(brandService, "Brand", "Brands");
    }

    @Override
    protected BrandDto createNewInstance() {
        return new BrandDto();
    }

}

