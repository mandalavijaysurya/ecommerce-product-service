package org.scaler.ecommereceproductservice.repository;

import org.scaler.ecommereceproductservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
