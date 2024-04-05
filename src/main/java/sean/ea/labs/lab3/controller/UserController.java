package sean.ea.labs.lab3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sean.ea.labs.lab3.dto.UserDto;
import sean.ea.labs.lab3.entity.User;
import sean.ea.labs.lab3.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> fetchAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto fetchOne(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto) {
        userService.create(userDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
