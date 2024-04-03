package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Review;
import com.sonny.ea.springdata.Entities.User;
import com.sonny.ea.springdata.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("Object not found"));
    }

    @Override
    public void update(Long id, User newObj) {
        User exist = repository.findById(id).orElse(null);
        if (exist != null) {
            if (!newObj.getEmail().isEmpty()) exist.setEmail(newObj.getEmail());
            if (!newObj.getFirstName().isEmpty()) exist.setFirstName(newObj.getFirstName());
            if (!newObj.getLastName().isEmpty()) exist.setLastName(newObj.getLastName());
            if (!newObj.getPassword().isEmpty()) exist.setPassword(newObj.getPassword());
            if (newObj.getReviews() != null ) exist.setReviews(newObj.getReviews());
            if (newObj.getAddress() != null ) exist.setAddress(newObj.getAddress());

            repository.save(exist);
        }
    }

    @Override
    public void add(User newObj) {
        repository.save(newObj);
    }

    @Override
    public void delete(Long id) {
        //clear all foreign key first
        repository.deleteById(id);
    }
}
