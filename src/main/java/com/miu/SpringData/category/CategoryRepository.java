package com.miu.SpringData.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
