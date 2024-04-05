package springData.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springData.example.demo.Repository.UserRepo;
import springData.example.demo.domain.User;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepo.findById(id);
    }
    public void createUser(User user){
        userRepo.save(user);
    }
    public void updateUser(User user){
       userRepo.save(user);
    }
    public void deleteUserById(long id){
        userRepo.deleteById(id);
    }
}
