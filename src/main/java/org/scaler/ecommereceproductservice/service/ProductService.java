package org.scaler.ecommereceproductservice.service;

import org.scaler.ecommereceproductservice.dto.ProductListResponseDTO;
import org.scaler.ecommereceproductservice.dto.ProductRequestDTO;
import org.scaler.ecommereceproductservice.dto.ProductResponseDTO;
import org.scaler.ecommereceproductservice.exception.ProductNotFoundException;
import org.scaler.ecommereceproductservice.model.Product;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(Long id) throws ProductNotFoundException;
    ProductListResponseDTO getLimitedProducts(Long limit);
    ProductListResponseDTO getAllProductsAndSort(String sort);
    ProductListResponseDTO getAllProductsAndSortAndLimit(String sort, Long limit);
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    String updateProduct(long id, ProductRequestDTO productRequestDTO);
    String deleteProduct(long id);
    ProductResponseDTO getProductByTitle(String title);
}
