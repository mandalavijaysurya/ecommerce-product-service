package org.scaler.ecommereceproductservice.client;

import org.scaler.ecommereceproductservice.dto.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Component
public class FakeStoreAPIClient {
    private String fakeStoreAPIUrl;
    private String fakeStoreProductApiUrl;
    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String createUrl = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(createUrl, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }
    public FakeStoreProductResponseDTO getProductById(Long product_id){
        String getProductsByIdUrl = "https://fakestoreapi.com/products/" + product_id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response =
                restTemplate.exchange(getProductsByIdUrl, HttpMethod.GET, null, FakeStoreProductResponseDTO.class);
        return response.getBody();
    }
    public FakeStoreProductListResponseDTO getAllProducts(){
        String getAllProductsUrl = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<FakeStoreProductResponseDTO>> productResponse =
                restTemplate.exchange(getAllProductsUrl, HttpMethod.GET,null,
                        new ParameterizedTypeReference<List<FakeStoreProductResponseDTO>>() {});
        return FakeStoreProductListResponseDTO.builder().fakeStoreProductListResponseDTO(productResponse.getBody()).build();
    }
    public String updateProduct(Long product_id, FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String updateUrl = "https://fakestoreapi.com/products/" + product_id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(updateUrl,fakeStoreProductRequestDTO);
        return "Product have been updated";
    }
    public String deleteProduct(Long product_id){
        String deleteUrl = "https://fakestoreapi.com/products/" + product_id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteUrl);
        return "Product have been updated";
    }
    public FakeStoreProductListResponseDTO getAllProductsAndSort(String sort){
        String getAllProductsUrl = "https://fakestoreapi.com/products";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(getAllProductsUrl)
                .queryParam("sort", sort);
        getAllProductsUrl = uriBuilder.toUriString();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<FakeStoreProductResponseDTO>> limitedProducts = restTemplate.exchange(getAllProductsUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<FakeStoreProductResponseDTO>>() {});
        return FakeStoreProductListResponseDTO.builder().fakeStoreProductListResponseDTO(limitedProducts.getBody()).build();
    }
    public FakeStoreProductListResponseDTO getLimitedProducts(Long limit){

        String getLimitedProductsBaseUrl = "https://fakestoreapi.com/products/";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(getLimitedProductsBaseUrl)
                .queryParam("limit", limit);
        String getLimitedProductsUrl = uriBuilder.toUriString();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> limitedProducts = restTemplate.exchange(getLimitedProductsUrl, HttpMethod.GET, null,
                FakeStoreProductResponseDTO[].class);
        List<FakeStoreProductResponseDTO> fakeProductResponseDTOList = new ArrayList<>();
        fakeProductResponseDTOList.addAll(Arrays.asList(limitedProducts.getBody()));
        FakeStoreProductListResponseDTO fakeStoreProductListResponseDTO = FakeStoreProductListResponseDTO.builder()
                .fakeStoreProductListResponseDTO(fakeProductResponseDTOList)
                .build();
        return fakeStoreProductListResponseDTO;
    }
}
