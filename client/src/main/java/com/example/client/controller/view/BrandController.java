package com.example.client.controller.view;

import com.example.client.domain.dto.BrandDto;
import com.example.client.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandController extends BaseController<BrandDto, Long> {

    public BrandController(BrandService brandService) {
        super(brandService, "Brand", "Brands");
    }

    @Override
    protected BrandDto createNewInstance() {
        return new BrandDto();
    }

}

