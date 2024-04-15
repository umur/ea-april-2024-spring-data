package com.ea.springjpa.service;

import com.ea.springjpa.entity.Address;
import com.ea.springjpa.entity.User;
import com.ea.springjpa.repository.UserRepository;
import com.ea.springjpa.request.UserRequest;
import com.ea.springjpa.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;



    public UserResponse createUser(UserRequest userRequest) {

        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        Address address = new Address();
        address.setCity(userRequest.getAddressRequest().getCity());
        address.setStreet(userRequest.getAddressRequest().getStreet());
        address.setZip(userRequest.getAddressRequest().getZip());
        user.setAddress(address);

        userRepository.save(user);
        return new UserResponse(user);
    }



    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::new).toList();
    }


    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserResponse(user);
    }


    public UserResponse updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        Address address = new Address();
        address.setCity(userRequest.getAddressRequest().getCity());
        address.setStreet(userRequest.getAddressRequest().getStreet());
        address.setZip(userRequest.getAddressRequest().getZip());
        user.setAddress(address);

        userRepository.save(user);
        return new UserResponse(user);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
