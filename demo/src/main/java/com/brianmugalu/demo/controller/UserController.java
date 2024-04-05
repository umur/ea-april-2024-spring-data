package com.brianmugalu.demo.controller;


import com.brianmugalu.demo.repository.entity.Address;
import com.brianmugalu.demo.repository.entity.Category;
import com.brianmugalu.demo.repository.entity.Review;
import com.brianmugalu.demo.repository.entity.User;
import com.brianmugalu.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping("/{id}/{password}")
    public User updateUserPassword(@PathVariable Long id, @PathVariable String password){
        return userService.updateUserPassword(id,password);
    }

    @GetMapping("/{id}")
    public Review getUserReviews(@PathVariable(name = "id") Long userId){
        return  userService.getUserReviews(userId);
    }

    @GetMapping("/address/{id}")
    public Address getUserAddress(@PathVariable(name = "id") Long userId){
        return userService.getUserAddress(userId);
    }

    @DeleteMapping("/{id}")
    public String deletedReview(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
