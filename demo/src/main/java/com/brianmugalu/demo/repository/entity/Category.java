package com.brianmugalu.demo.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
    private List<Product>productList;

    public void addProduct(Product product){
        productList.add(product);
    }
}
