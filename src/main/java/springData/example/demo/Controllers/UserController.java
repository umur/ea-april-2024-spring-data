package springData.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springData.example.demo.Service.UserService;
import springData.example.demo.domain.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

@GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
    }
}
