package org.scaler.ecommereceproductservice.service;

import org.scaler.ecommereceproductservice.dto.ProductListResponseDTO;
import org.scaler.ecommereceproductservice.dto.ProductRequestDTO;
import org.scaler.ecommereceproductservice.dto.ProductResponseDTO;
import org.scaler.ecommereceproductservice.model.Product;
import org.springframework.stereotype.Service;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return null;
    }

    @Override
    public ProductListResponseDTO getLimitedProducts(Long limit) {
        return null;
    }

    @Override
    public ProductListResponseDTO getAllProductsAndSort(String sort) {
        return null;
    }

    @Override
    public ProductListResponseDTO getAllProductsAndSortAndLimit(String sort, Long limit) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public String updateProduct(long id, ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public String deleteProduct(long id) {
        return null;
    }
}
