package com.example.labData.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    private long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
