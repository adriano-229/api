package com.adriano.api_rest_client.controller.view;

import com.adriano.api_rest_client.domain.dto.ProductDTO;
import com.adriano.api_rest_client.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController<ProductDTO, Long> {

    public ProductController(ProductService productService) {
        super(productService, "Product", "products");
    }

    @Override
    protected ProductDTO createNewInstance() {
        return new ProductDTO();
    }

    @Override
    protected void populateFormModel(Model model, ProductDTO entity) {
        model.addAttribute("entity", entity);
    }
}

