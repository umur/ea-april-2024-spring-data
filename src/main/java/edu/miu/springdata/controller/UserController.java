package edu.miu.springdata.controller;

import edu.miu.springdata.entity.User;
import edu.miu.springdata.service.UserService;
import edu.miu.springdata.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable long id, @RequestBody User user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.delete(id);
    }
}
