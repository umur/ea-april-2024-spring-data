package miu.edu.eaapril2024springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.eaapril2024springdata.entity.Address;
import miu.edu.eaapril2024springdata.entity.User;
import miu.edu.eaapril2024springdata.service.AddressService;
import miu.edu.eaapril2024springdata.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody User user) {
        userService.update(id, user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
