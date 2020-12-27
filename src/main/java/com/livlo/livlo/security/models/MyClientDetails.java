package com.livlo.livlo.security.models;


import com.livlo.livlo.entities.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyClientDetails implements UserDetails {

    private Client user;
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    public MyClientDetails(Client user) {
        this.user = user;
        getAuthorities();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        authorities.add(new SimpleGrantedAuthority(Roles.CLIENT.name()));
        return authorities;
    }

    public Client getUser() {
        return user;
    }

    public void setUser(Client user) {
        this.user = user;
    }

    public String getPhone() {
        return user.getPhone();
    }
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
