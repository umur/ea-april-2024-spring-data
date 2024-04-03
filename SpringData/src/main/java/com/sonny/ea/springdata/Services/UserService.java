package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Review;
import com.sonny.ea.springdata.Entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    void update(Long id, User newObj);
    void add(User newObj);
    void delete(Long id);
}
