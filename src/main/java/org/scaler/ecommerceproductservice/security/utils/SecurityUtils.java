package org.scaler.ecommerceproductservice.security.utils;

import org.scaler.ecommerceproductservice.dtos.RoleDTO;
import org.scaler.ecommerceproductservice.dtos.UserDTO;
import org.scaler.ecommerceproductservice.security.models.ProductServiceUserDetails;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public class SecurityUtils {
    public static ProductServiceUserDetails convertUserDtoToProductServiceUserDetails(UserDTO userDTO){
        return new ProductServiceUserDetails(userDTO);
    }
    public static ProductServiceUserDetails convertDetailsToProductServiceUserDetails(String email, String roles){
        List<RoleDTO> roleList = Arrays.stream(roles.split(",")).map(RoleDTO::new).toList();
        return new ProductServiceUserDetails(email, roleList);
    }
}
