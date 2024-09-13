package org.scaler.ecommerceproductservice.controlleradvices;

import jakarta.servlet.http.HttpServletRequest;
import org.scaler.ecommerceproductservice.dtos.ErrorResponseDTO;
import org.scaler.ecommerceproductservice.exceptions.CategoryNotFoundException;
import org.scaler.ecommerceproductservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}