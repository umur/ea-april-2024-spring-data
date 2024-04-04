package miu.ea.springdata.service;

import miu.ea.springdata.entity.Product;
import miu.ea.springdata.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
}
