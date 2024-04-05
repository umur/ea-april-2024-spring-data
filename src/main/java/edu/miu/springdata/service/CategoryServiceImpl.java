package edu.miu.springdata.service;

import edu.miu.springdata.entity.Category;
import edu.miu.springdata.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public boolean update(long id, Category category) {

        if(categoryRepo.findById(id).isPresent()){
            Category cat = categoryRepo.findById(id).get();
            cat.setName(category.getName());
            categoryRepo.save(cat);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void deleteById(long id) {
        categoryRepo.deleteById(id);
    }
}
