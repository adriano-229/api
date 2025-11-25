package com.example.client.controller.view;

import com.example.client.domain.dto.CategoryDTO;
import com.example.client.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController extends BaseController<CategoryDTO, Long> {

    public CategoryController(CategoryService categoryService) {
        super(categoryService, "Category", "categories");
    }

    @Override
    protected CategoryDTO createNewInstance() {
        return new CategoryDTO();
    }
}
