package com.example.labData.Service;

import com.example.labData.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(long id);
    void save(User user);
    void update(User user);
    void delete(long id);
}
