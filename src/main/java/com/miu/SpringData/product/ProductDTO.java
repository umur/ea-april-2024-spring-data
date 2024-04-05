package com.miu.SpringData.product;

import com.miu.SpringData.category.CategoryDTO;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private double rating;

    private CategoryDTO category;
}
