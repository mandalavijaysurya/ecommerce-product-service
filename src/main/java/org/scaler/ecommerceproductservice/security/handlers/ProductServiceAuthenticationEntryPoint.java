package org.scaler.ecommerceproductservice.security.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.scaler.ecommerceproductservice.dtos.ErrorResponseDTO;
import org.scaler.ecommerceproductservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Component
public class ProductServiceAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final HandlerExceptionResolver exceptionResolver;
    private final ObjectMapper objectMapper;

    public ProductServiceAuthenticationEntryPoint(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver exceptionResolver, ObjectMapper objectMapper) {
        this.exceptionResolver = exceptionResolver;
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
//        System.out.println("Authentication Exception: " + authException.getMessage());
        if(authException instanceof BadCredentialsException && authException.getMessage().contains("401")){
            response.setStatus(401);
            response.setContentType("application/json");
            response.getWriter().write("Invalid token");
        }
//        exceptionResolver.resolveException(request, response, null, authException);
    }
}
