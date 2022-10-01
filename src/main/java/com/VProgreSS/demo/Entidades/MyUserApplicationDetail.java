package com.VProgreSS.demo.Entidades;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUserApplicationDetail implements UserDetails {

    //Atributes Wilur
    private String username;
    private String password;
    private GrantedAuthority authorities;

    //Constructor UserApplication
    public MyUserApplicationDetail(UsersApplication UserApplication){
        this.username=UserApplication.getUserApplication();
        this.password=UserApplication.getPasswordUser();
        this.authorities = new SimpleGrantedAuthority(UserApplication.getRolUser());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
