package miu.ea.springdata.service;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Address;
import miu.ea.springdata.entity.Category;
import miu.ea.springdata.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if(optionalCategory.isPresent()){
            Category existedCategory = optionalCategory.get();

            existedCategory.setName(category.getName());
            existedCategory.setProductList(category.getProductList());
            return categoryRepository.save(existedCategory);
        } else {
            // Handle the case where the address with the given ID does not exist
            throw new RuntimeException("Category with ID " + category.getId() + " not found");
        }
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
