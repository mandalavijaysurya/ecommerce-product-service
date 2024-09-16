package org.scaler.ecommerceproductservice.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.scaler.ecommerceproductservice.commons.AuthenticationCommons;
import org.scaler.ecommerceproductservice.dtos.UserDTO;
import org.scaler.ecommerceproductservice.security.models.ProductServiceUserDetails;
import org.scaler.ecommerceproductservice.security.utils.SecurityUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

public class ProductServiceAuthenticationFilter extends OncePerRequestFilter {
    private final AuthenticationCommons authenticationCommons;

    public ProductServiceAuthenticationFilter(AuthenticationCommons authenticationCommons){
        this.authenticationCommons = authenticationCommons;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        System.out.println(token);
        if (token == null || token.isEmpty()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token is missing");
            return;
        }
        UserDTO userDTO = authenticationCommons.validateToken(token);
        if(userDTO == null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }

        ProductServiceUserDetails productServiceUserDetails = SecurityUtils.convertUserDtoToProductServiceUserDetails(userDTO);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                productServiceUserDetails,
                null,
                productServiceUserDetails.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        System.out.println("everything went fine in filter");
        filterChain.doFilter(request, response);
    }
}
