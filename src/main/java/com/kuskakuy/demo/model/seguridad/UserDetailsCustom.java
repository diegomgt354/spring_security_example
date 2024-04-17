package com.kuskakuy.demo.model.seguridad;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsCustom implements UserDetails{
    
    private static final long serialVersionUID = 1L;

    private final UserEntity userEntity;

    public UserDetailsCustom(final UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userEntity.getRoles().stream().map(
                authority -> new SimpleGrantedAuthority(authority.getName())
        ).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override

    public String getUsername() {
        return userEntity.getUserName();
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

    public User getUserDetails() {
        return new User(userEntity.getUserName(), userEntity.getPassword(), this.getAuthorities());
    }
    
}
