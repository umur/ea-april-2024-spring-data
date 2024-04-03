package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Address;
import com.sonny.ea.springdata.Entities.Category;
import com.sonny.ea.springdata.Repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Object not found"));
    }

    @Override
    public void updateCategory(Long id, Category category) {
        Category exist = categoryRepository.findById(id).orElse(null);
        if (exist != null) {
            if (!category.getName().isEmpty()) exist.setName(category.getName());
            if (!category.getProducts().isEmpty()) exist.setProducts(category.getProducts());

            categoryRepository.save(exist);
        }
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        //find all product to clear category
        categoryRepository.deleteById(id);
    }
}
