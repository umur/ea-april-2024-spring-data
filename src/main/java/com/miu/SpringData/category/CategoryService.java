package com.miu.SpringData.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {

        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .toList();
    }

    public String newCategories(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.setName(categoryDTO.getName());

        this.categoryRepository.save(category);

        return "Successfully added.";
    }

    public String updateCategories(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());

        this.categoryRepository.save(category);

        return "Successfully updated.";
    }

    public String deleteCategories(CategoryDTO categoryDTO) {

        this.categoryRepository.deleteById(categoryDTO.getId());

        return "Successfully deleted.";
    }

    public Category getCategory(long id) {
        return categoryRepository.findById(id).orElse(new Category());
    }
}
