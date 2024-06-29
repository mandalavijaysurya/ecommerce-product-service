package org.scaler.ecommereceproductservice.service;

import lombok.AllArgsConstructor;
import org.scaler.ecommereceproductservice.dto.ProductListResponseDTO;
import org.scaler.ecommereceproductservice.dto.ProductResponseDTO;
import org.scaler.ecommereceproductservice.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Service("fakeStoreProductService")
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    @Override
    public ProductListResponseDTO getAllProducts() {
        String getAllProductsUrl = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<ProductResponseDTO>> productResponse =
                restTemplate.exchange(getAllProductsUrl, HttpMethod.GET,null, new ParameterizedTypeReference<List<ProductResponseDTO>>() {});
        return ProductListResponseDTO.builder().productResponseDTOList(productResponse.getBody()).build();
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }
}
