package com.example.springdata1.services;


import com.example.springdata1.domain.Category;
import com.example.springdata1.dto.CategoryRequest;
import com.example.springdata1.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(long id){
        return categoryRepository.findById(id).get();
    }

    public Category updateCategory(long id, CategoryRequest categoryRequest){
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if(existingCategory != null){
            existingCategory.setName(categoryRequest.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public void deleteCategoryById(long id){
        categoryRepository.deleteById(id);
    }
}
