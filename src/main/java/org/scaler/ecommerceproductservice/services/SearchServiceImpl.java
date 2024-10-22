package org.scaler.ecommerceproductservice.services;

import org.scaler.ecommerceproductservice.models.Product;
import org.scaler.ecommerceproductservice.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Service
public class SearchServiceImpl implements SearchService {

    private final ProductRepository productRepository;

    public SearchServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Page<Product> search(String query, int pageNumber, int pageSize) {
        Sort sort = Sort.by("title").descending();
//                .and(Sort.by("price").ascending()).ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Product> page = productRepository.findByTitleContaining(query, pageable);
        return page;
    }

}
