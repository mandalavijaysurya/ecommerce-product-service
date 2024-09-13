package org.scaler.ecommerceproductservice.controllers;

import org.scaler.ecommerceproductservice.services.ProductService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@RestController
public class ProductController {

    // Inject ProductService using constructor injection
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}
