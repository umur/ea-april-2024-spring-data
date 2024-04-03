package com.sonny.ea.springdata.Services;

import com.sonny.ea.springdata.Entities.Product;
import com.sonny.ea.springdata.Entities.Review;
import com.sonny.ea.springdata.Repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository repository;

    @Override
    public List<Review> getAll() {
        return repository.findAll();
    }

    @Override
    public Review getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("Object not found"));
    }

    @Override
    public void update(Long id, Review newObj) {
        Review exist = repository.findById(id).orElse(null);
        if (exist != null) {
            if (!newObj.getComment().isEmpty()) exist.setComment(newObj.getComment());
            repository.save(exist);
        }
    }

    @Override
    public void add(Review newObj) {
        repository.save(newObj);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
