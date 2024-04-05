package springData.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springData.example.demo.Repository.ReviewRepo;
import springData.example.demo.domain.Review;

import java.util.List;
import java.util.Optional;

@Service

public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    public List<Review> getReviews(){
        return reviewRepo.findAll();
    }
    public Optional<Review> getReviewById(Long id){
        return reviewRepo.findById(id);
    }
    public void createReview(Review review){
        reviewRepo.save(review);
    }
    public void updateReview(Review review){
        reviewRepo.save(review);
    }
    public void deleteReviewById(long id){
        reviewRepo.deleteById(id);
    }
    public List<Review> findAllByProduct_Id(long id){
        return reviewRepo.findAllByProduct_Id(id);
    }
}
