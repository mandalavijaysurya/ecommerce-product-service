package org.scaler.ecommereceproductservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Getter
@Setter
@Entity(name = "PRODUCT")
public class Product extends BaseModel{
    private String title;
    private String description;
    @ManyToOne
    private Category category;
    private String image;
    @OneToOne
    private Price price;

}
