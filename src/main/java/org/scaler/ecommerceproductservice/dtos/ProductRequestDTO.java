package org.scaler.ecommerceproductservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private String productName;
    private String productDescription;
    private String imageURL;
    private String categoryName;
    private double amount;
    private double discount;
    private String currencyCode;
}
