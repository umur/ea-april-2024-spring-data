package miu.ea.springdata.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    private String rating;

//    A Product can belong to only one Category.
//    A Product can have many Reviews
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Review> reviewList;

}
