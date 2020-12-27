package com.livlo.livlo.entities;

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
public class Courier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courier_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false ,unique = true)
    private String phone;
    private String adress;
    private double longuitude;
    private double latitude;
    private boolean disponible;
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date birthday;
    private int warning;
    private String status;
    @Column(unique = true)
    private String cin;
    @OneToMany(mappedBy="courier",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = false)
    private List<Order> ordersdeliverd;

    public Courier(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}