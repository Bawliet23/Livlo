package com.livlo.livlo.models.dto;

import com.livlo.livlo.entities.Order;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderDTO {
    private Long id;
    private String defaulAdress;
    private double longuitude;
    private double latitude;
    private boolean delivred;
    private List<ProductsOrderDTO> items;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.defaulAdress = order.getDefaulAdress();
        this.longuitude = order.getLonguitude();
        this.latitude = order.getLatitude();
        this.delivred = order.isDelivred();
        this.items = order.getItems().stream().map(ProductsOrderDTO::new).collect(Collectors.toList());
        System.out.println(items.size()+" ***********");
    }
}
