package edu.miu.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Review {

    @Id
    private Long id;
    private String comment;

    @JsonBackReference(value = "product-review")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private  Product product;

    @JsonBackReference(value = "user-review")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
