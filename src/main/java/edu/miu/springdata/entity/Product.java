package edu.miu.springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

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
