package com.brianmugalu.demo.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    private int rating;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Review>reviewList;
}
