package org.scaler.ecommerceproductservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Getter
@Setter
@Entity(name = "categories")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel {
    private String name;
}
