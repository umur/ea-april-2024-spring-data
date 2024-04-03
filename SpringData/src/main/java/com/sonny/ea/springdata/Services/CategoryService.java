package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategory(Long id);

    void updateCategory(Long id, Category category);
    void createCategory(Category category);
    void deleteCategory(Long id);
}
