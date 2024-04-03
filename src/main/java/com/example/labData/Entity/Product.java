package com.example.labData.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private long id;
    private String name;
    private String color;

    @JoinColumn
    @OneToMany//(mappedBy = "p1")
    private List<Review> reviews;
}
