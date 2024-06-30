package org.scaler.ecommereceproductservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Getter
@Setter
@Builder
public class ProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

}
