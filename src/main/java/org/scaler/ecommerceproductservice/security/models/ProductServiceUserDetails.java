package org.scaler.ecommerceproductservice.security.models;
import lombok.Builder;
import org.scaler.ecommerceproductservice.dtos.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public class ProductServiceUserDetails implements UserDetails {

    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;

    public ProductServiceUserDetails(UserDTO userDTO){
        this.userName = userDTO.getEmail();
        this.password = null;
        this.authorities = userDTO.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }
}
