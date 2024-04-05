package com.example.labData.Controller;

import com.example.labData.Entity.Category;
import com.example.labData.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/")
    public List<Category> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void save(Category category) {
        service.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Category category) {
        service.update(category);
    }
}
