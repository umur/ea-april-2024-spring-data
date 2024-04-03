package miu.ea.lab3.service;

import lombok.RequiredArgsConstructor;
import miu.ea.lab3.model.Review;
import miu.ea.lab3.model.User;
import miu.ea.lab3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new RuntimeException("User does not exist: " + user.getId())
        );
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAddress(user.getAddress());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
