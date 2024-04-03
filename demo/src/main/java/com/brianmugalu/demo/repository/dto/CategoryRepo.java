package com.brianmugalu.demo.repository.dto;

import com.brianmugalu.demo.repository.entity.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category,Long> {
}
