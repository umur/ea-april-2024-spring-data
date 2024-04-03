package com.sonny.ea.springdata.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    private Long id;

    private String name;
    private Float price;
    private Float rating;

    @ManyToOne
    private Category category;

    @JoinColumn(name = "product_id")
    @OneToMany
    private List<Review> reviews;
}
