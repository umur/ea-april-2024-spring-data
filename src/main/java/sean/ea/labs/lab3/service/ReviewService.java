package sean.ea.labs.lab3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sean.ea.labs.lab3.entity.Product;
import sean.ea.labs.lab3.entity.Review;
import sean.ea.labs.lab3.entity.User;
import sean.ea.labs.lab3.repository.ProductRepo;
import sean.ea.labs.lab3.repository.ReviewRepo;
import sean.ea.labs.lab3.repository.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;

    public void create(Long userId, Long productId, Review review) {
        User user = userRepo.getReferenceById(userId);
        Product product = productRepo.getReferenceById(productId);
        review.setUser(user);
//        review.setProduct(product);
        reviewRepo.save(review);
    }

    public void update(Long id, Review review) {
        Review oldReview = reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        oldReview.setComment(review.getComment());
        reviewRepo.save(oldReview);
    }

    public Review get(Long id) {
        return reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public List<Review> getAll() {
        return reviewRepo.findAll();
    }

    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }
}
