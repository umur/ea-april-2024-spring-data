package com.miu.SpringData.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> index() {
        return ResponseEntity.ok(this.userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getDetails(@PathVariable long id) {
        return ResponseEntity.ok(this.userService.getUser(id));
    }

    @PostMapping("/new")
    public ResponseEntity<String> newProduct(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.newUser(userDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.updateUser(userDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCategory(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.deleteUser(userDTO));
    }
}
