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
                .id(fakeStoreProductResponseDTO.getId()).build();
    }
    public static ProductListResponseDTO fakeProductListResponseDTOToProductListResponseDTO(FakeStoreProductListResponseDTO fakeStoreProductListResponseDTO) {
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductListResponseDTO.getFakeStoreProductListResponseDTO()){
            productResponseDTOList.add(fakeProductResponseToProductResponseDTO(fakeStoreProductResponseDTO));
        }
        return ProductListResponseDTO.builder().productResponseDTOList(productResponseDTOList).build();
    }
}
