package com.livlo.livlo.models.dto;

import com.livlo.livlo.entities.Product;
import com.livlo.livlo.entities.ProductsOrder;
import lombok.Data;

@Data
public class ProductsOrderDTO {

    private Long id;
    private int quantity;
    private ProductDTO product;

    public ProductsOrderDTO(ProductsOrder pr) {
        this.id = pr.getId();
        this.quantity = pr.getQuantity();
        this.product = new ProductDTO(pr.getProduct());
    }
}
