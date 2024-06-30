package org.scaler.ecommereceproductservice.service;

import org.scaler.ecommereceproductservice.dto.ProductListResponseDTO;
import org.scaler.ecommereceproductservice.dto.ProductResponseDTO;
import org.scaler.ecommereceproductservice.model.Product;

import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductListResponseDTO getLimitedProducts(Long limit);
    ProductListResponseDTO getAllProductsAndSort(String sort);
    ProductListResponseDTO getAllProductsAndSortAndLimit(String sort, Long limit);
    Product createProduct(Product product);
    Product updateProduct(long id, Product product);
    Product deleteProduct(long id);
}
