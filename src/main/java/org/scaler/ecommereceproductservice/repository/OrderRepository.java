package org.scaler.ecommereceproductservice.repository;

import org.scaler.ecommereceproductservice.model.EcomOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<EcomOrder, UUID> {
}