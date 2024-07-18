package org.scaler.ecommereceproductservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;
import org.scaler.ecommereceproductservice.annotation.UUID4Generator;

import java.util.UUID;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(generator = "uuid-v6-generator")
    @GenericGenerator(name = "uuid-v6-generator", strategy = "org.scaler.ecommereceproductservice.generator.SortedUUIDGenerator")
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;
}
