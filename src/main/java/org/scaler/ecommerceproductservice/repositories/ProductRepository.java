package org.scaler.ecommerceproductservice.repositories;

import org.scaler.ecommerceproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByTitle(String title);
}
