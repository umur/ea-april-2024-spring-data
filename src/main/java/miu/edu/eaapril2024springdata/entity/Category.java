package miu.edu.eaapril2024springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
