package com.livlo.livlo.models.dto;

import com.livlo.livlo.entities.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String image;
    private double price;
    private String description;

    public ProductDTO(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.image = p.getImage();
        this.price = p.getPrice();
        this.description = p.getDescription();
    }



}
