package com.example.client.controller.view;

import com.example.client.domain.dto.ProductDto;
import com.example.client.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController<ProductDto, Long> {

    public ProductController(ProductService productService) {
        super(productService, "Product", "Products");
    }

    @Override
    protected ProductDto createNewInstance() {
        return new ProductDto();
    }
}

