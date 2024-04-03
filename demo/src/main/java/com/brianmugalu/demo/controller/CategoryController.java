package com.brianmugalu.demo.controller;

import com.brianmugalu.demo.repository.entity.Category;
import com.brianmugalu.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @PutMapping("/{id}/{name}")
    public Category updateCategoryName(@PathVariable Long id, @PathVariable String name){
        return categoryService.updateCategoryName(name,id);
    }

    @GetMapping("/{id}")
    public Category getSingleCategoryById(@PathVariable Long id){
        return  categoryService.getSingleCategoryById(id);
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}