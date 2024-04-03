package edu.miu.cs544.labs.Lab2.service;

import edu.miu.cs544.labs.Lab2.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    void save(User user);

    void delete(Long id);

    void update(User user);
}
