package org.scaler.ecommerceproductservice.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.scaler.ecommerceproductservice.commons.ProductUtils;
import org.scaler.ecommerceproductservice.dtos.*;
import org.scaler.ecommerceproductservice.models.Category;
import org.scaler.ecommerceproductservice.models.Product;
import org.scaler.ecommerceproductservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    // Inject ProductService using constructor injection
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<ProductListResponseDTO> getAllProducts( @RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset) {
        /*

        UserDTO userDTO = authenticationCommons.validateToken(token);
        if(userDTO == null){
            throw new InvalidTokenException("Invalid Token");
        }
        */
        ProductListResponseDTO responseDTO = ProductUtils.convertProductListToProductListResponseDTO(productService.getAllProducts(limit, offset));
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/title")
    public ResponseEntity<ProductResponseDTO> getProductByTitle(@RequestParam String title) {
        Product product = productService.getProduct(title);
        ProductResponseDTO responseDTO = ProductUtils.convertProductToProductResponseDTO(product);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/")
    public ResponseEntity<ProductResponseDTO> addProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        /*
        UserDTO userDTO = authenticationCommons.validateToken(token);
        if(userDTO == null){
            throw new InvalidTokenException("Invalid Token");
        }
        */
        log.info("productRequestDTO: {}", productRequestDTO);
        Product product = productService.createProduct(productRequestDTO.getProductName(), productRequestDTO.getProductDescription(), productRequestDTO.getImageURL(), productRequestDTO.getCategoryName(), productRequestDTO.getAmount(), productRequestDTO.getDiscount(), productRequestDTO.getCurrencyCode());
        ProductResponseDTO responseDTO = ProductUtils.convertProductToProductResponseDTO(product);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteProduct(@RequestParam String id) {
        UUID productId = UUID.fromString(id);
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryResponseDTO> addCategory( @RequestBody CategoryRequestDTO categoryRequestDTO) {
        /*
        UserDTO userDTO = authenticationCommons.validateToken(token);

        if(userDTO == null){
            throw new InvalidTokenException("Invalid Token");
        }
        */
        Category category = productService.createCategory(categoryRequestDTO.getName());
        CategoryResponseDTO responseDTO = ProductUtils.convertCategoryToCategoryResponseDTO(category);
        return ResponseEntity.ok(responseDTO);
    }

}
