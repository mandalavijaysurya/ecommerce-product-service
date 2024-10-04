package org.scaler.ecommerceproductservice.security.utils;

import org.scaler.ecommerceproductservice.dtos.UserDTO;
import org.scaler.ecommerceproductservice.security.models.ProductServiceUserDetails;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public class SecurityUtils {
    public static ProductServiceUserDetails convertUserDtoToProductServiceUserDetails(UserDTO userDTO){
        return new ProductServiceUserDetails(userDTO);
    }
}
