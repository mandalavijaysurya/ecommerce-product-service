package org.scaler.ecommereceproductservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class EcomOrder extends BaseModel {
    @ManyToMany
    private List<Product> products;
}
