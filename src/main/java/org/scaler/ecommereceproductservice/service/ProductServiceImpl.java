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
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


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
                restTemplate.exchange(getAllProductsUrl, HttpMethod.GET,null,
                        new ParameterizedTypeReference<List<ProductResponseDTO>>() {});
        return ProductListResponseDTO.builder().productResponseDTOList(productResponse.getBody()).build();
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        String getProductsByIdUrl = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> response =
                restTemplate.exchange(getProductsByIdUrl, HttpMethod.GET, null, ProductResponseDTO.class);
        return response.getBody();
    }

    @Override
    public ProductListResponseDTO getLimitedProducts(Long limit) {
        String getLimitedProductsBaseUrl = "https://fakestoreapi.com/products/";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(getLimitedProductsBaseUrl)
                .queryParam("limit", limit);
        String getLimitedProductsUrl = uriBuilder.toUriString();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<ProductResponseDTO>> limitedProducts = restTemplate.exchange(getLimitedProductsUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ProductResponseDTO>>() {});
        return ProductListResponseDTO.builder().productResponseDTOList(limitedProducts.getBody()).build();
    }

    @Override
    public ProductListResponseDTO getAllProductsAndSort(String sort) {
        String getAllProductsUrl = "https://fakestoreapi.com/products";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(getAllProductsUrl)
                .queryParam("sort", sort);
        getAllProductsUrl = uriBuilder.toUriString();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<ProductResponseDTO>> limitedProducts = restTemplate.exchange(getAllProductsUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ProductResponseDTO>>() {});
        return ProductListResponseDTO.builder().productResponseDTOList(limitedProducts.getBody()).build();
    }
    @Override
    public ProductListResponseDTO getAllProductsAndSortAndLimit(String sort, Long limit) {
        ProductListResponseDTO getAllProductsAndSort = getAllProductsAndSort(sort);
        getAllProductsAndSort.setProductResponseDTOList(getAllProductsAndSort.getProductResponseDTOList().stream().limit(limit).toList());
        return getAllProductsAndSort;
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
