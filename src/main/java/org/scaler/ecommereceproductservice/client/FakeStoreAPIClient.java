package org.scaler.ecommereceproductservice.client;

import org.scaler.ecommereceproductservice.dto.*;
import org.springframework.beans.factory.annotation.Value;
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
    private final String fakeStoreAPIUrl;
    private final String fakeStoreProductApi;
    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreAPIUrl, @Value("${fakestore.api.url.products}")String fakeStoreProductApi) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIUrl = fakeStoreAPIUrl;
        this.fakeStoreProductApi = fakeStoreProductApi;
    }
    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String createUrl = fakeStoreAPIUrl + fakeStoreProductApi;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(createUrl, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }
    public FakeStoreProductResponseDTO getProductById(Long product_id){
        String getProductsByIdUrl = fakeStoreAPIUrl + fakeStoreProductApi + product_id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response =
                restTemplate.exchange(getProductsByIdUrl, HttpMethod.GET, null, FakeStoreProductResponseDTO.class);
        return response.getBody();
    }
    public FakeStoreProductListResponseDTO getAllProducts(){
        String getAllProductsUrl = fakeStoreAPIUrl + fakeStoreProductApi;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<FakeStoreProductResponseDTO>> productResponse =
                restTemplate.exchange(getAllProductsUrl, HttpMethod.GET,null,
                        new ParameterizedTypeReference<List<FakeStoreProductResponseDTO>>() {});
        return FakeStoreProductListResponseDTO.builder().fakeStoreProductListResponseDTO(productResponse.getBody()).build();
    }
    public String updateProduct(Long product_id, FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String updateUrl = fakeStoreAPIUrl + fakeStoreProductApi + product_id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(updateUrl,fakeStoreProductRequestDTO);
        return "Product have been updated";
    }
    public String deleteProduct(Long product_id){
        String deleteUrl = fakeStoreAPIUrl + fakeStoreProductApi + product_id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteUrl);
        return "Product have been updated";
    }
    public FakeStoreProductListResponseDTO getAllProductsAndSort(String sort){
        String getAllProductsUrl = fakeStoreAPIUrl + fakeStoreProductApi;
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(getAllProductsUrl)
                .queryParam("sort", sort);
        getAllProductsUrl = uriBuilder.toUriString();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List<FakeStoreProductResponseDTO>> limitedProducts = restTemplate.exchange(getAllProductsUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<FakeStoreProductResponseDTO>>() {});
        return FakeStoreProductListResponseDTO.builder().fakeStoreProductListResponseDTO(limitedProducts.getBody()).build();
    }
    public FakeStoreProductListResponseDTO getLimitedProducts(Long limit){

        String getLimitedProductsBaseUrl = fakeStoreAPIUrl + fakeStoreProductApi;
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
