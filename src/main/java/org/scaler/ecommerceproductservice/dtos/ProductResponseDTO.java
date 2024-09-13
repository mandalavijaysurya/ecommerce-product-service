package org.scaler.ecommerceproductservice.dtos;

import lombok.*;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private String productName;
    private String productDescription;
    private String productImageURL;
    private String productPrice;
    private String productCategory;
}
