package com.example.springdata1.services;


import com.example.springdata1.domain.User;
import com.example.springdata1.dto.UserRequest;
import com.example.springdata1.repositories.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
@Data
public class UserService {
    private final UserRepository userRepository;


    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).get();
    }

    public User updateUser(long id, UserRequest newUser){
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser != null){
            existingUser.setFirstName(newUser.getFirstName());
            existingUser.setLastName(newUser.getLastName());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setPassword(newUser.getPassword());

            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }



}
