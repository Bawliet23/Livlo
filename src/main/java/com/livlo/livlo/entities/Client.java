package com.livlo.livlo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false ,unique = true)
    private String phone;
    private String adress;
    private double longuitude;
    private double latitude;
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date birthday;
    private int warning;
    private String status;
    @OneToMany(mappedBy="client",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = false)
    @JsonIgnore
    private List<Order> orders;

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Client(String name, String phone, String adress, Date birthday) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.birthday = birthday;
    }
}
