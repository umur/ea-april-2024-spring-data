package com.sonny.ea.springdata.Controllers;

import com.sonny.ea.springdata.Entities.Review;
import com.sonny.ea.springdata.Entities.User;
import com.sonny.ea.springdata.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    User get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    void add(@RequestBody User newObj) {
        service.add(newObj);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody User newObj) {
        service.update(id, newObj);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
