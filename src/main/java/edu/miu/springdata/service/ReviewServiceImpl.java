package edu.miu.springdata.service;

import edu.miu.springdata.entity.Review;
import edu.miu.springdata.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    @Override
    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Review save(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public boolean update(long id, Review review) {

        if(reviewRepo.findById(id).isPresent()){
            Review rev = reviewRepo.findById(id).get();
            rev.setComment(review.getComment());
            reviewRepo.save(rev);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void deleteById(long id) {
        reviewRepo.deleteById(id);

    }
}
