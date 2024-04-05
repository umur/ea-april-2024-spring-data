package com.miu.SpringData.user;

import com.miu.SpringData.address.Address;
import com.miu.SpringData.address.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public List<User> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .toList();
    }

    public String newUser(UserDTO userDTO) {
        User user = new User();
        Address address = new Address();

        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());

        if(userDTO.getAddress().getId() != 0)
            address.setId(userDTO.getAddress().getId());
        address.setStreet(userDTO.getAddress().getStreet());
        address.setCity(userDTO.getAddress().getCity());
        address.setZip(userDTO.getAddress().getZip());

        System.out.println(address.getStreet());
        System.out.println(address.getCity());
        System.out.println(address.getZip());

        address = addressRepository.save(address);

        user.setAddress(address);

        this.userRepository.save(user);

        return "Successfully added.";
    }

    public String updateUser(UserDTO userDTO) {
        User user = new User();
        Address address = new Address();

        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());

        address.setId(userDTO.getAddress().getId());
        address.setStreet(userDTO.getAddress().getStreet());
        address.setCity(userDTO.getAddress().getCity());
        address.setZip(userDTO.getAddress().getZip());

        address = addressRepository.save(address);

        user.setAddress(address);

        this.userRepository.save(user);

        return "Successfully updated.";
    }

    public String deleteUser(UserDTO userDTO) {
        this.addressRepository.deleteById(userDTO.getAddress().getId());
        this.userRepository.deleteById(userDTO.getId());

        return "Successfully deleted.";
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElse(new User());
    }
}
