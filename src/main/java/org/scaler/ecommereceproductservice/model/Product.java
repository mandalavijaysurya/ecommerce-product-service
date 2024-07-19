package org.scaler.ecommereceproductservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Getter
@Setter
@Entity(name = "ECOM_PRODUCT")
@ToString
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    @OneToOne
    private Price price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
//    @ManyToMany(mappedBy = "products")
//    private List<Order> orders;
}
