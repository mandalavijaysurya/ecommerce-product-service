package org.scaler.ecommereceproductservice.controller;

import lombok.AllArgsConstructor;
import org.scaler.ecommereceproductservice.dto.ProductListResponseDTO;
import org.scaler.ecommereceproductservice.dto.ProductRequestDTO;
import org.scaler.ecommereceproductservice.dto.ProductResponseDTO;
import org.scaler.ecommereceproductservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService")ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<ProductListResponseDTO> getAllProducts(
            @RequestParam(required = false) Long limit,
            @RequestParam(required = false) String sort){
        if(limit == null && sort == null)
            return ResponseEntity.ok(productService.getAllProducts());
        else if(sort == null)
            return ResponseEntity.ok(productService.getLimitedProducts(limit));
        else if(limit == null)   return ResponseEntity.ok(productService.getAllProductsAndSort(sort));
        else return ResponseEntity.ok(productService.getAllProductsAndSortAndLimit(sort, limit));
    }
    @GetMapping("/products/{prod_id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long prod_id){
        return ResponseEntity.ok(productService.getProductById(prod_id));
    }
    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }
    @PutMapping("/products/{product_id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long product_id, @RequestBody ProductRequestDTO productRequestDTO){
        return ResponseEntity.ok(productService.updateProduct(product_id, productRequestDTO));
    }
    @DeleteMapping("/products/{product_id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long product_id){
        return ResponseEntity.ok(productService.deleteProduct(product_id));
    }

}
