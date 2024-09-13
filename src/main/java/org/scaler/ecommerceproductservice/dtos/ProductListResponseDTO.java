package org.scaler.ecommerceproductservice.dtos;

import lombok.*;

import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductListResponseDTO {
    private List<ProductResponseDTO> productResponse;
}
