package com.livlo.livlo.security.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String phone;
    private String adress;
    private double longuitude;
    private double latitude;
    private java.util.Date birthday;
    private int warning;
    private String status;
}
