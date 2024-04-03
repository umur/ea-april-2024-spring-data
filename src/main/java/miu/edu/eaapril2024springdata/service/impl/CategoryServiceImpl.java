package miu.edu.eaapril2024springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.Category;
import miu.edu.eaapril2024springdata.repository.CategoryRepository;
import miu.edu.eaapril2024springdata.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Long id, Category category) {
        Category c = categoryRepository.getById(id);
        c.setName(category.getName());
        categoryRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
