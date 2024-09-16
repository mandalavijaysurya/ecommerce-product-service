package org.scaler.ecommerceproductservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserDTO{
    private String name;
    private String email;
    private List<RoleDTO> roles;
}
