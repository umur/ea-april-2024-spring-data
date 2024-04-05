package com.brianmugalu.demo.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int rating;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_category")
    @JsonIgnore
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Review>reviewList;

    public void addReview(Review review){
        reviewList.add(review);
    }
}
