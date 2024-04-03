package com.sonny.ea.springdata.Controllers;

import com.sonny.ea.springdata.Entities.Category;
import com.sonny.ea.springdata.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<Category> getAll() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    Category get(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping
    void add(@RequestBody Category category) {
        categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody Category category) {
        categoryService.updateCategory(id,category);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
