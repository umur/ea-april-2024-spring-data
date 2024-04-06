package com.example.springdata1.controller;


import com.example.springdata1.domain.Category;
import com.example.springdata1.dto.CategoryRequest;
import com.example.springdata1.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @Operation(summary = "Saves a category", description = "This API will save the category")
    @PostMapping
    public ResponseEntity<Category> createCategory(Category category){
        Category savedCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @Operation(summary = "Gets all categories", description = "This API will fetch all the categories available")
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @Operation(summary = "Gets a category by id", description = "This API will fetch a category using id")
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @Operation(summary = "Updates a category", description = "This API will update the category and its attributes")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable long id, @RequestBody CategoryRequest categoryRequest){
        categoryService.updateCategory(id, categoryRequest);
        return ResponseEntity.ok("Category updated successfully");
    }

    @Operation(summary = "Deletes a category", description = "This API will delete a category by the given id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Category deleted successfully");
    }

}
