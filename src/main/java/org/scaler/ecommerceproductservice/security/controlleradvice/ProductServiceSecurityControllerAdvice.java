package org.scaler.ecommerceproductservice.security.controlleradvice;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.websocket.AuthenticationException;
import org.scaler.ecommerceproductservice.dtos.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.time.LocalDateTime.now;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

//@ControllerAdvice
public class ProductServiceSecurityControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<ErrorResponseDTO> handleAuthenticationException(HttpServletRequest request, HttpServletResponse response, ServletException exception){
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusCode("401")
                .message(exception.getMessage())
                .timestamp(now())
                .build();
        return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(errorResponseDTO);
    }
}
