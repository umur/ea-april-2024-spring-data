package com.miu.SpringData.category;

import com.miu.SpringData.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> index() {

        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getDetails(@PathVariable long id) {
        return ResponseEntity.ok(this.categoryService.getCategory(id));
    }

    @PostMapping("/new")
    public ResponseEntity<String> newCategory(@RequestBody CategoryDTO categoryDTO) {

        return ResponseEntity.ok(this.categoryService.newCategories(categoryDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryDTO categoryDTO) {

        return ResponseEntity.ok(this.categoryService.updateCategories(categoryDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCategory(@RequestBody CategoryDTO categoryDTO) {

        return ResponseEntity.ok(this.categoryService.deleteCategories(categoryDTO));
    }

}
