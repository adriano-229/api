package com.example.client.controller.view;

import com.example.client.domain.dto.BrandDTO;
import com.example.client.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandController extends BaseController<BrandDTO, Long> {

    public BrandController(BrandService brandService) {
        super(brandService, "Brand", "brands");
    }

    @Override
    protected BrandDTO createNewInstance() {
        return new BrandDTO();
    }
}
