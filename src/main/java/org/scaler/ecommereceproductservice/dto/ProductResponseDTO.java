package org.scaler.ecommereceproductservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Getter
@Setter
public class ProductResponseDTO {
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;
}
