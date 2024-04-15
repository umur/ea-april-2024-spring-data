package com.ea.springjpa.controller;

import com.ea.springjpa.request.UserRequest;
import com.ea.springjpa.response.UserResponse;
import com.ea.springjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;



    @PostMapping
    public UserResponse createUser(UserRequest userRequest) {
        return userService.createUser(userRequest);
    }


    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
