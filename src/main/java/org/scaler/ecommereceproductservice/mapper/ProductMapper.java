package org.scaler.ecommereceproductservice.mapper;

import org.scaler.ecommereceproductservice.dto.*;
import org.scaler.ecommereceproductservice.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public class ProductMapper {
    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequestDTO(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());
        return fakeStoreProductRequestDTO;
    }
    public static ProductResponseDTO fakeProductResponseToProductResponseDTO(FakeStoreProductResponseDTO fakeStoreProductResponseDTO) {
        return ProductResponseDTO.builder()
                .price(fakeStoreProductResponseDTO.getPrice())
                .title(fakeStoreProductResponseDTO.getTitle())
                .image(fakeStoreProductResponseDTO.getImage())
                .category(fakeStoreProductResponseDTO.getCategory())
                .description(fakeStoreProductResponseDTO.getDescription())
                .id(fakeStoreProductResponseDTO.getId()+"").build();
    }
    public static ProductListResponseDTO fakeProductListResponseDTOToProductListResponseDTO(FakeStoreProductListResponseDTO fakeStoreProductListResponseDTO) {
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductListResponseDTO.getFakeStoreProductListResponseDTO()){
            productResponseDTOList.add(fakeProductResponseToProductResponseDTO(fakeStoreProductResponseDTO));
        }
        return ProductListResponseDTO.builder().productResponseDTOList(productResponseDTOList).build();
    }
    public static ProductListResponseDTO convertProductListToProductListResponseDTO(List<Product> products) {
        return ProductListResponseDTO.builder()
                .productResponseDTOList(products.stream()
                        .map( i ->  (
                            ProductResponseDTO.builder()
                                    .id(i.getId().toString())
                                    .price(i.getPrice().getAmount())
                                    .description(i.getDescription())
                                    .category(i.getCategory().getCategoryName())
                                    .title(i.getTitle())
                                    .image(i.getImage())
                                    .build()
                        )
                ).toList()).build();
    }
    public static ProductResponseDTO convertProductToProductResponseDTO(Product product){
        return ProductResponseDTO.builder()
                .image(product.getImage())
                .id(product.getId().toString())
                .price(product.getPrice().getAmount())
                .title(product.getTitle())
                .category(product.getCategory().getCategoryName())
                .description(product.getDescription())
                .build();
    }
}
