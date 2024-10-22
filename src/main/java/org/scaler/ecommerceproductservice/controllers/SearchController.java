package org.scaler.ecommerceproductservice.controllers;

import org.scaler.ecommerceproductservice.dtos.SearchRequestDTO;
import org.scaler.ecommerceproductservice.models.Product;
import org.scaler.ecommerceproductservice.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchRequestDTO searchRequestDTO) {
        return searchService.search(searchRequestDTO.getQuery(), searchRequestDTO.getPageNumber(), searchRequestDTO.getPageSize());
    }
}
