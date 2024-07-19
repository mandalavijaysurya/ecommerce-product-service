package org.scaler.ecommereceproductservice.service;

import lombok.AllArgsConstructor;
import org.scaler.ecommereceproductservice.client.FakeStoreAPIClient;
import org.scaler.ecommereceproductservice.dto.*;
import org.scaler.ecommereceproductservice.exception.ProductNotFoundException;
import org.scaler.ecommereceproductservice.mapper.ProductMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import static org.scaler.ecommereceproductservice.mapper.ProductMapper.fakeProductListResponseDTOToProductListResponseDTO;
import static org.scaler.ecommereceproductservice.mapper.ProductMapper.fakeProductResponseToProductResponseDTO;
import static org.scaler.ecommereceproductservice.util.ProductUtils.isNull;


/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Service("fakeStoreProductService")
@AllArgsConstructor
public class FakeStoreProductService implements ProductService {

    private FakeStoreAPIClient fakeStoreAPIClient;

    @Override
    public ProductListResponseDTO getAllProducts() {
        FakeStoreProductListResponseDTO fakeStoreProductListResponseDTO = fakeStoreAPIClient.getAllProducts();
        return fakeProductListResponseDTOToProductListResponseDTO(fakeStoreProductListResponseDTO);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductDTO = fakeStoreAPIClient.getProductById(id);
        if(isNull(fakeStoreProductDTO))
            throw new ProductNotFoundException("Product not found with id: " + id);
        return fakeProductResponseToProductResponseDTO(fakeStoreProductDTO);
    }

    @Override
    public ProductListResponseDTO getLimitedProducts(Long limit) {
        return fakeProductListResponseDTOToProductListResponseDTO(fakeStoreAPIClient.getLimitedProducts(limit));
    }

    @Override
    public ProductListResponseDTO getAllProductsAndSort(String sort) {
       FakeStoreProductListResponseDTO fakeStoreProductListResponseDTO = fakeStoreAPIClient.getAllProductsAndSort(sort);
        return ProductMapper.fakeProductListResponseDTOToProductListResponseDTO(fakeStoreProductListResponseDTO);
    }
    @Override
    public ProductListResponseDTO getAllProductsAndSortAndLimit(String sort, Long limit) {
        ProductListResponseDTO getAllProductsAndSort = getAllProductsAndSort(sort);
        getAllProductsAndSort.setProductResponseDTOList(getAllProductsAndSort.getProductResponseDTOList().stream().limit(limit).toList());
        return getAllProductsAndSort;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = ProductMapper.productRequestToFakeStoreProductRequestDTO(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeProductResponseToProductResponseDTO(fakeStoreProductDTO);
    }

    @Override
    public String updateProduct(long id, ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = ProductMapper.productRequestToFakeStoreProductRequestDTO(productRequestDTO);
        return fakeStoreAPIClient.updateProduct(id, fakeStoreProductRequestDTO);
    }

    @Override
    public String deleteProduct(long id) {
        return fakeStoreAPIClient.deleteProduct(id);
    }

    @Override
    public ProductResponseDTO getProductByTitle(String title) {
        return null;
    }
}
