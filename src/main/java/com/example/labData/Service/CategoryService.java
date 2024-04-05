package com.example.labData.Service;

import com.example.labData.Entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(long id);
    void save(Category category);
    void update(Category category);
    void delete(long id);
}
