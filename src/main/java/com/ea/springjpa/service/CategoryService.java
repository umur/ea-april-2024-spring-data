package com.ea.springjpa.service;

import com.ea.springjpa.entity.Category;
import com.ea.springjpa.repository.CategoryRepository;
import com.ea.springjpa.request.CategoryRequest;
import com.ea.springjpa.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;



    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return new CategoryResponse(category.getId(), category.getName());
    }



    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryResponse(category.getId(), category.getName())).toList();
    }


    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return new CategoryResponse(category.getId(), category.getName());
    }


    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return new CategoryResponse(category.getId(), category.getName());
    }


    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
