package com.livlo.livlo.security.models;

import lombok.Data;

import java.util.List;
@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private User user;
    private List<String> roles;


    public JwtResponse(String token, User user, List<String> roles) {
        this.token = token;
        this.user=user;
        this.roles = roles;
    }
}