package com.ea.springjpa.controller;

import com.ea.springjpa.request.CategoryRequest;
import com.ea.springjpa.response.CategoryResponse;
import com.ea.springjpa.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        return categoryService.createCategory(categoryRequest);
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }


    @PutMapping("/{id}")
    public CategoryResponse updateCategory(@PathVariable Long id, CategoryRequest categoryRequest) {
        return categoryService.updateCategory(id, categoryRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
