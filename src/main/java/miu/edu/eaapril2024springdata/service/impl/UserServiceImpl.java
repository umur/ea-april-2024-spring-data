package miu.edu.eaapril2024springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.User;
import miu.edu.eaapril2024springdata.repository.UserRepository;
import miu.edu.eaapril2024springdata.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(Long id, User user) {
        User u = userRepository.getById(id);
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        userRepository.save(u);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
