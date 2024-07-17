package org.scaler.ecommereceproductservice.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Getter
@Setter
@Entity(name = "CATEGORY")
public class Category extends BaseModel{
    private String categoryName;
}
