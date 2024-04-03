package com.brianmugalu.demo.repository.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    private Long id;
    private String comment;
    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
