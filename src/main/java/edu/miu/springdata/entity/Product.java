package edu.miu.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Product {

    @Id
    private Long id;
    private String name;
    private double price;
    private double rating;

    @JsonBackReference(value = "category-product")
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @JsonManagedReference(value = "product-review")
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Review> reviews;

}
