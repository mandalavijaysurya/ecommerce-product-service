package org.scaler.ecommerceproductservice.controlleradvices;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.scaler.ecommerceproductservice.dtos.ErrorResponseDTO;
import org.scaler.ecommerceproductservice.exceptions.CategoryAlreadyExistsException;
import org.scaler.ecommerceproductservice.exceptions.CategoryNotFoundException;
import org.scaler.ecommerceproductservice.exceptions.InvalidTokenException;
import org.scaler.ecommerceproductservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import static java.time.LocalDateTime.now;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCategoryNotFoundException(HttpServletRequest request, CategoryNotFoundException categoryNotFoundException) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(categoryNotFoundException.getMessage())
                .statusCode("404")
                .path(request.getRequestURI())
                .timestamp(now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(HttpServletRequest request, ProductNotFoundException productNotFoundException) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(productNotFoundException.getMessage())
                .statusCode("404")
                .path(request.getRequestURI())
                .timestamp(now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidTokenException(HttpServletRequest request, InvalidTokenException invalidTokenException) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(invalidTokenException.getMessage())
                .statusCode("401")
                .path(request.getRequestURI())
                .timestamp(now())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponseDTO);
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleCategoryAlreadyExistsException(HttpServletRequest request, CategoryAlreadyExistsException categoryAlreadyExistsException) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(categoryAlreadyExistsException.getMessage())
                .statusCode("409")
                .path(request.getRequestURI())
                .timestamp(now())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDTO);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponseDTO> handleAuthenticationException(HttpServletRequest request, HttpServletResponse response, ServletException exception) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusCode("401")
                .message(exception.getMessage())
                .timestamp(now())
                .build();
        return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(errorResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(HttpServletRequest request, Exception exception) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(exception.getMessage())
                .statusCode("500")
                .path(request.getRequestURI())
                .timestamp(now())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
    }
}
