package miu.edu.eaapril2024springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {

    @Id
    private Long id;
    private String comment;

    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
}
