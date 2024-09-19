package org.scaler.ecommerceproductservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.scaler.ecommerceproductservice.commons.AuthenticationCommons;
import org.scaler.ecommerceproductservice.dtos.UserDTO;
import org.scaler.ecommerceproductservice.security.models.ProductServiceUserDetails;
import org.scaler.ecommerceproductservice.security.utils.SecurityUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

public class ProductServiceAuthenticationFilter extends OncePerRequestFilter {
    private final AuthenticationCommons authenticationCommons;

    public ProductServiceAuthenticationFilter(AuthenticationCommons authenticationCommons) {
        this.authenticationCommons = authenticationCommons;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        System.out.println(token);
        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token in missing");
            return;
        }
        try {
            UserDTO userDTO = authenticationCommons.validateToken(token);
            ProductServiceUserDetails productServiceUserDetails = SecurityUtils.convertUserDtoToProductServiceUserDetails(userDTO);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    productServiceUserDetails,
                    null,
                    productServiceUserDetails.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            System.out.println("everything went fine in filter");
        }catch (HttpClientErrorException ex){
            throw new BadCredentialsException(ex.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
