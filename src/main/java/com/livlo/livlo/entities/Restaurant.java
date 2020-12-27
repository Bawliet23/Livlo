package com.livlo.livlo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyGroup;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private Long id;
    private String name;
    private String image;
    @OneToMany(mappedBy="restaurant",cascade = CascadeType.ALL,fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Product> products;
}
