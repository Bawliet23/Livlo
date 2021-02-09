package com.livlo.livlo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.livlo.livlo.utils.Env;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    private String name;
    private String image;
    private double price;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id",nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    public String getImage() {
        return Env.getUrlImages()+image;
    }

}
