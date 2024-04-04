package miu.ea.springdata.service;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Address;
import miu.ea.springdata.entity.Product;
import miu.ea.springdata.entity.User;
import miu.ea.springdata.repository.AddressRepository;
import miu.ea.springdata.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent()){
            User existedUser = optionalUser.get();

            existedUser.setEmail(user.getEmail());
            existedUser.setFirstName(user.getFirstName());
            existedUser.setLastName(user.getLastName());
            existedUser.setPassword(user.getPassword());
            existedUser.setAddress(user.getAddress());
            existedUser.setReviewList(user.getReviewList());

            return userRepository.save(existedUser);
        } else {
            // Handle the case where the address with the given ID does not exist
            throw new RuntimeException("User with ID " + user.getId() + " not found");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
