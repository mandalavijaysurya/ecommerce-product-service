package org.scaler.ecommerceproductservice.controllers;

import org.scaler.ecommerceproductservice.commons.ProductUtils;
import org.scaler.ecommerceproductservice.dtos.ProductListResponseDTO;
import org.scaler.ecommerceproductservice.dtos.ProductRequestDTO;
import org.scaler.ecommerceproductservice.dtos.ProductResponseDTO;
import org.scaler.ecommerceproductservice.models.Product;
import org.scaler.ecommerceproductservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    // Inject ProductService using constructor injection
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<ProductListResponseDTO> getAllProducts(@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset) {
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
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
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

}
