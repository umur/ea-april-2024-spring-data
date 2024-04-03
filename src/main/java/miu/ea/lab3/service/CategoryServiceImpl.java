package miu.ea.lab3.service;

import lombok.RequiredArgsConstructor;
import miu.ea.lab3.model.Category;
import miu.ea.lab3.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category existingCat = categoryRepository.findById(category.getId()).orElseThrow(
                () -> new RuntimeException("Category does not exist")
        );
        existingCat.setName(category.getName());
        return categoryRepository.save(existingCat);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
