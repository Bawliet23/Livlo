package com.livlo.livlo.security.models;

import com.livlo.livlo.entities.Courier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyCourierDetails implements UserDetails {

    private Courier user;
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    public MyCourierDetails(Courier user) {
        this.user = user;
        getAuthorities();
    }

    public Courier getUser() {
        return user;
    }

    public void setUser(Courier user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        authorities.add(new SimpleGrantedAuthority(Roles.COURIER.name()));
        return authorities;
    }

    public String getPhone() {
        return user.getPhone();
    }
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() { return user.getName(); }

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
