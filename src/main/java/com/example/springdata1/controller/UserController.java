package com.example.springdata1.controller;

import com.example.springdata1.domain.User;
import com.example.springdata1.dto.UserRequest;
import com.example.springdata1.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @Operation(summary = "Saves a user", description = "This API will save the user")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Gets all users", description = "This API will fetch all the users available")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Gets a user by id", description = "This API will fetch a user using id")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id, @RequestBody UserRequest userRequest){
        userService.updateUser(id, userRequest);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}
