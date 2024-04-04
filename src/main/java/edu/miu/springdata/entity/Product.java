package edu.miu.springdata.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {

    @Id
    private long id;
    private String name;
    private double price;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
