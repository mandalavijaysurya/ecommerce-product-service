package org.scaler.ecommereceproductservice.service;

import org.scaler.ecommereceproductservice.dto.ProductListResponseDTO;
import org.scaler.ecommereceproductservice.dto.ProductRequestDTO;
import org.scaler.ecommereceproductservice.dto.ProductResponseDTO;
import org.scaler.ecommereceproductservice.mapper.ProductMapper;
import org.scaler.ecommereceproductservice.model.Product;
import org.scaler.ecommereceproductservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ProductListResponseDTO getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return ProductMapper.convertProductListToProductListResponseDTO(productList);
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

    @Override
    public ProductResponseDTO getProductByTitle(String title) {
        Product product = productRepository.findByTitle(title);
        System.out.println(product);
        return ProductMapper.convertProductToProductResponseDTO(product);
    }
}
