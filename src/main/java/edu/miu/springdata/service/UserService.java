package edu.miu.springdata.service;

import edu.miu.springdata.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAll();

    User getUser(long id);
    boolean update(long id, User user);
    void delete(long id);

}
