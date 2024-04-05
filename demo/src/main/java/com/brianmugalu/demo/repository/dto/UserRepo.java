package com.brianmugalu.demo.repository.dto;

import com.brianmugalu.demo.repository.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ListCrudRepository<User,Long> {
}
