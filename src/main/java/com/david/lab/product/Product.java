package com.david.lab.product;

import com.david.lab.category.Category;
import com.david.lab.review.Review;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal price;
    private String rating;

    @JsonBackReference
    @ManyToOne
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "reviewedProduct")
    private List<Review> reviews;
}
