package com.miu.SpringData.review;

import com.miu.SpringData.product.Product;
import com.miu.SpringData.product.ProductRepository;
import com.miu.SpringData.user.User;
import com.miu.SpringData.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<Review> getReviews() {
        return StreamSupport.stream(reviewRepository.findAll().spliterator(), false)
                .toList();
    }

    public String newReview(ReviewDTO reviewDTO) {
        User user = userRepository.findById(reviewDTO.getUser().getId()).orElseThrow();
        Product product = productRepository.findById(reviewDTO.getUser().getId()).orElseThrow();

        Review review = new Review();
        review.setComment(reviewDTO.getComment());
        review.setUser(user);
        review.setProduct(product);

        reviewRepository.save(review);
        return "Successfully added.";
    }

    public String updateReview(ReviewDTO reviewDTO) {
        //User user = userRepository.findById(reviewDTO.getUser().getId()).orElseThrow();
        //Product product = productRepository.findById(reviewDTO.getUser().getId()).orElseThrow();

        Review review = reviewRepository.findById(reviewDTO.getId()).orElseThrow();
        review.setComment(reviewDTO.getComment());
        //review.setUser(user);
        //review.setProduct(product);

        reviewRepository.save(review);
        return "Successfully updated.";
    }

    public String deleteReview(ReviewDTO reviewDTO) {
        reviewRepository.deleteById(reviewDTO.getId());
        return "Successfully deleted.";
    }

    public Review getReview(long id) {
        return reviewRepository.findById(id).orElse(new Review());
    }

    public List<Review> getReviewsOfProduct(Long productId) {
        return reviewRepository.findByProductId(productId);
    }
}
