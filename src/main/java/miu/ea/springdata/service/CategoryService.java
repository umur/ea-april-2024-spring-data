package miu.ea.springdata.service;

import miu.ea.springdata.entity.Address;
import miu.ea.springdata.entity.Category;

import java.util.List;

public interface CategoryService{
    //CRUD
    List<Category> getAllCategory();

    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Long id);
}
