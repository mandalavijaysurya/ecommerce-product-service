package org.scaler.ecommerceproductservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.scaler.ecommerceproductservice.annotations.UUIDV6Generator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class BaseModel implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid-v6-generator")
    @UUIDV6Generator
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;
}
