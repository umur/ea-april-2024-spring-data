package com.brianmugalu.demo.repository.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User userR;
}
