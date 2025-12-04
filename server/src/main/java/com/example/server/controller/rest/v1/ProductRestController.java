package com.example.server.controller.rest.v1;

import com.example.server.domain.dto.ProductDto;
import com.example.server.domain.entity.Product;
import com.example.server.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController extends BaseRestController<Product, ProductDto, Long> {

    public ProductRestController(ProductService productService) {
        super(productService);
    }
}

