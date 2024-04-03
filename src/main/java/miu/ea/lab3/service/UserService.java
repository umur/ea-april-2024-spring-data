package miu.ea.lab3.service;

import miu.ea.lab3.model.Review;
import miu.ea.lab3.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User update(User user);
    void delete(Long id);
    List<User> getAll();
}
