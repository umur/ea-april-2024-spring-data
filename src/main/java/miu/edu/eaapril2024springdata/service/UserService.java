package miu.edu.eaapril2024springdata.service;

import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.entity.User;

import java.util.List;

public interface UserService {
    User getById(Long id);
    List<User> getAll();
    void add(User user);
    void update(Long id, User user);
    void delete(Long id);
}
