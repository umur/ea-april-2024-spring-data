package miu.ea.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Product;
import miu.ea.springdata.entity.User;
import miu.ea.springdata.repository.UserRepository;
import miu.ea.springdata.service.ProductService;
import miu.ea.springdata.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //CRUD of Product
    //Get all address
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> result = userService.getAllUser();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Create Address
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User result = userService.addUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Update Address
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User result = userService.updateUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //Delete Address
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "Delete Successfully ";
    }
}
