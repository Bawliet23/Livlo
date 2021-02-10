package com.livlo.livlo.entities;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductsOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productsorder_id")
    private Long id;
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id" ,nullable = false)
    private Product product;
}