package com.david.lab.review;

import com.david.lab.product.Product;
import com.david.lab.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;

    @JsonBackReference
    @ManyToOne
    private Product reviewedProduct;

    @JsonBackReference
    @ManyToOne
    private User submittedUser;
}
