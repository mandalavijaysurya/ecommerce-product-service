package org.scaler.ecommerceproductservice.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequestDTO {
    @NotNull
    private String productName;
    @NotNull
    private String productDescription;
    @NotNull
    @NotEmpty
    private String imageURL;
    @NotNull
    private String categoryName;
    @NotNull
    private double amount;
    @NotNull
    private double discount;
    @NotNull
    private String currencyCode;
}
