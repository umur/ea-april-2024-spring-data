package sean.ea.labs.lab3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sean.ea.labs.lab3.dto.CategoryDto;
import sean.ea.labs.lab3.entity.Category;
import sean.ea.labs.lab3.exception.ResourceNotFoundException;
import sean.ea.labs.lab3.repository.CategoryRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public void create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepo.save(category);
    }

    public void update(Long id, CategoryDto categoryDto) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        category.setName(categoryDto.getName());
        categoryRepo.save(category);
    }

    public CategoryDto get(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return new CategoryDto(category.getId(), category.getName());
    }

    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map(c -> new CategoryDto(c.getId(), c.getName())).toList();
    }

    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
