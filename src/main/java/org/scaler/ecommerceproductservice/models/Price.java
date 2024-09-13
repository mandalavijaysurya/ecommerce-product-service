package org.scaler.ecommerceproductservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Entity(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Price extends BaseModel{
    private String currencyCode;
    private double amount;
    private double discount;
}
