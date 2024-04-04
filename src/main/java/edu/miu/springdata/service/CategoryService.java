package edu.miu.springdata.service;

import edu.miu.springdata.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();

    public Category save(Category category);

    public boolean update(long id, Category category);

    public void deleteById(long id);


}
