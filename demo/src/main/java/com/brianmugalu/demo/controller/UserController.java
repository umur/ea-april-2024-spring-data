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
public class UserController {
    private final UserService userService;

    @PostMapping
    public Category addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping("/{id}/{password}")
    public Category updateUserPassword(@PathVariable Long id, @PathVariable String password){
        return userService.updateUserPassword(id,password);
    }

    @GetMapping
    public Review getUserReviews(){
        return  userService.getUserReviews();
    }

    @GetMapping("/address")
    public Address getUserAddress(){
        return userService.getUserAddress();
    }

    @DeleteMapping("/{id}")
    public String deletedReview(@PathVariable Long id){
        return userService.deletedReview(id);
    }
}
