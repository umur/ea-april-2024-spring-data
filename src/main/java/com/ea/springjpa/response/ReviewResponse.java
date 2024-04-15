package com.ea.springjpa.response;


import com.ea.springjpa.entity.Review;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewResponse {

    private String comment;

    private Long productId;



    public ReviewResponse(Review review) {
        this.comment = review.getComment();
        this.productId = review.getProduct().getId();
    }
}
