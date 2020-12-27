package com.livlo.livlo.security.models;

import lombok.Data;

import java.util.List;
@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String name;
    private String phone;
    private List<String> roles;


    public JwtResponse(String token, Long id, String name, String phone, List<String> roles) {
        this.token = token;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.roles = roles;
    }
}