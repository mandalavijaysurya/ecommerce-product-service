package org.scaler.ecommereceproductservice.model;

import jakarta.persistence.Entity;
import lombok.*;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Price extends BaseModel{
    private String currency;
    private double amount;
    private double discount;
}
