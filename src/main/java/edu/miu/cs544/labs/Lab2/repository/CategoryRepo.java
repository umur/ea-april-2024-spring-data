package edu.miu.cs544.labs.Lab2.repository;

import edu.miu.cs544.labs.Lab2.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepo extends ListCrudRepository<Category, Long> {
}
