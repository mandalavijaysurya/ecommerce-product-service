package org.scaler.ecommerceproductservice.dtos;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDTO {
    private String message;
    private String statusCode;
    private String path;
    private LocalDateTime timestamp;
}
