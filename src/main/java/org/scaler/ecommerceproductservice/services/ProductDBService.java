package org.scaler.ecommerceproductservice.services;

import org.scaler.ecommerceproductservice.models.Product;
import org.scaler.ecommerceproductservice.repositories.CategoryRepository;
import org.scaler.ecommerceproductservice.repositories.PriceRepository;
import org.scaler.ecommerceproductservice.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */


@Service
public class ProductDBService implements ProductService{

    // Inject ProductRepository, CategoryRepository and PriceRepository using constructor injection
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    public ProductDBService(ProductRepository productRepository, CategoryRepository categoryRepository, PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    // Implement this method to return all products, use productRepository to fetch all products in paginated manner
    @Override
    public List<Product> getAllProducts(int limit, int offset) {
        Pageable pageable = Pageable.ofSize(limit).withPage(offset);
        Page<Product> productsPage = productRepository.findAll(pageable);
        return productsPage.getContent();
    }

    @Override
    public Product getProduct(String title) {
        return null;
    }

    @Override
    public List<Product> getLimitedProducts(Long limit) {
        return List.of();
    }

    @Override
    public List<Product> getAllProductsAndSort(String sort) {
        return List.of();
    }

    @Override
    public List<Product> getAllProductsAndSortAndLimit(String sort, Long limit) {
        return List.of();
    }

    @Override
    public Product createProduct(String title, String description, String imageURL, String category, double amount, double discount, String currencyCode) {
        return null;
    }

    @Override
    public String updateProduct(UUID id, String title, String description, String imageURL, String category, double amount, double discount, String currencyCode) {
        return "";
    }

    @Override
    public String deleteProduct(UUID id) {
        return "";
    }
}
