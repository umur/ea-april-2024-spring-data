package miu.ea.springdata.service;

import lombok.RequiredArgsConstructor;
import miu.ea.springdata.entity.Address;
import miu.ea.springdata.entity.Review;
import miu.ea.springdata.entity.User;
import miu.ea.springdata.repository.AddressRepository;
import miu.ea.springdata.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewImpl implements ReviewService{

    private final ReviewRepository reviewRepository;


    @Override
    public List<Review> getAllReview() {
        return (List<Review>) reviewRepository.findAll();
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(review.getId());
        if(optionalReview.isPresent()){
            Review existedReview = optionalReview.get();

            existedReview.setComment(review.getComment());
            existedReview.setProduct(review.getProduct());
            existedReview.setUser(review.getUser());


            return reviewRepository.save(existedReview);
        } else {
            // Handle the case where the address with the given ID does not exist
            throw new RuntimeException("Review with ID " + review.getId() + " not found");
        }
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> getAllReviewOfProduct(Long id) {
        return reviewRepository.findByProductId(id);
    }
}
