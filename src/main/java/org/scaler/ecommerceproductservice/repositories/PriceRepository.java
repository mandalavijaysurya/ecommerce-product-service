package org.scaler.ecommerceproductservice.repositories;

import org.scaler.ecommerceproductservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {

}
