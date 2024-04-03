package edu.miu.cs544.labs.Lab2.repository;

import edu.miu.cs544.labs.Lab2.entity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepo extends ListCrudRepository<User, Long> {
}
