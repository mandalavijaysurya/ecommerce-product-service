package org.scaler.ecommereceproductservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Getter
@Setter
@Builder
public class ProductRequestDTO {
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;
}
