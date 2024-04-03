package com.brianmugalu.demo.service;

import com.brianmugalu.demo.repository.dto.CategoryRepo;
import com.brianmugalu.demo.repository.entity.Category;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public String deleteCategory(Long id) {
        categoryRepo.deleteById(id);
        return "Product Deleted Successfully";
    }

    @Transactional
    public Category updateCategoryName(String name, Long id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));
        category.setName(name);
        categoryRepo.save(category);
        return category;
    }

    public Category getSingleCategoryById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " not found"));
    }

    public List<Category> getAllCategories() {
        return  categoryRepo.findAll();
    }
}
