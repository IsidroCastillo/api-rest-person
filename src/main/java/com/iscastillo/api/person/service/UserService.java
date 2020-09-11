package com.iscastillo.api.person.service;

import com.iscastillo.api.person.model.dto.PersonDto;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public class UserService implements UserDetails {

    private int idPerson;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserService(int idPerson, String email, String password, List<GrantedAuthority> authorities) {
        this.idPerson = idPerson;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    public static UserService build(PersonDto personDto) {
        List<GrantedAuthority> authorities = personDto.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRoleName().name())).collect(Collectors.toList());
        return new UserService(personDto.getIdPerson(), personDto.getEmail(),
                personDto.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public long getIdPerson() {
        return idPerson;
    }
    @Override
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return null;
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
