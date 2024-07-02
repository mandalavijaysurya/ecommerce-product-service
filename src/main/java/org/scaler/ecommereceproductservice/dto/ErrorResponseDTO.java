package org.scaler.ecommereceproductservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Getter
@Setter
public class ErrorResponseDTO {
    private String message;
    private int messageCode;
}
