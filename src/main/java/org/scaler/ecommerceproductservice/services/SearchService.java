package org.scaler.ecommerceproductservice.services;

import org.scaler.ecommerceproductservice.models.Product;
import org.springframework.data.domain.Page;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

public interface SearchService {
    Page<Product> search(String query, int pageNumber, int pageSize);
}
