package com.example.labData.Service;

import com.example.labData.Entity.Category;
import com.example.labData.Repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo repo;
    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Category> findById(long id) {

        return repo.findById(id);
    }

    @Override
    public void save(Category category) {
        repo.save(category);
    }

    @Override
    public void update(Category category) {
        repo.save(category);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
