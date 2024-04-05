package com.miu.SpringData.review;

import com.miu.SpringData.product.ProductDTO;
import com.miu.SpringData.user.UserDTO;
import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    private String comment;
    private ProductDTO product;
    private UserDTO user;
}
