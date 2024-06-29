package org.scaler.ecommereceproductservice.controller;

import lombok.AllArgsConstructor;
import org.scaler.ecommereceproductservice.dto.ProductListResponseDTO;
import org.scaler.ecommereceproductservice.dto.ProductResponseDTO;
import org.scaler.ecommereceproductservice.model.Product;
import org.scaler.ecommereceproductservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

    @GetMapping("/products")
    public ProductListResponseDTO getAllProducts(){
        return productService.getAllProducts();
    }
}
