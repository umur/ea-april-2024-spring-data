package com.example.springdata1.repositories;


import com.example.springdata1.domain.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {

}
