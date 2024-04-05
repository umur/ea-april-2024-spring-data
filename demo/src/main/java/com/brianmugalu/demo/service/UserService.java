package com.brianmugalu.demo.service;

import com.brianmugalu.demo.repository.dto.UserRepo;
import com.brianmugalu.demo.repository.entity.Address;
import com.brianmugalu.demo.repository.entity.Category;
import com.brianmugalu.demo.repository.entity.Review;
import com.brianmugalu.demo.repository.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User addUser(User user) {
        userRepo.save(user);
        return  user;
    }
    @Transactional
    public User updateUserPassword(Long id, String password) {
        User user = userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Address with id " + id + " not found"));
        user.setPassword(password);
        return user;
    }

    public Review getUserReviews(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("Address with id " + userId + " not found"));
        return (Review) user.getReviewList();
    }

    public Address getUserAddress(Long userId) {
        User user =  userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("Address with id " + userId + " not found"));
        return  user.getAddress();
    }

    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "User deleted Successfully";
    }

}
