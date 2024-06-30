package org.scaler.ecommereceproductservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Getter
@Setter
@Builder
public class ProductListResponseDTO {
    private List<ProductResponseDTO> productResponseDTOList;

}
