package org.scaler.ecommerceproductservice.services;

import org.scaler.ecommerceproductservice.exceptions.CategoryNotFoundException;
import org.scaler.ecommerceproductservice.exceptions.ProductNotFoundException;
import org.scaler.ecommerceproductservice.models.Category;
import org.scaler.ecommerceproductservice.models.Price;
import org.scaler.ecommerceproductservice.models.Product;
import org.scaler.ecommerceproductservice.repositories.CategoryRepository;
import org.scaler.ecommerceproductservice.repositories.PriceRepository;
import org.scaler.ecommerceproductservice.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public List<Product> getAllProducts(Integer limit, Integer offset) {
        if(limit != null) {
            Pageable pageable = Pageable.ofSize(limit).withPage(offset);
            Page<Product> productsPage = productRepository.findAll(pageable);
            return productsPage.getContent();
        }
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String title) {
        Optional<Product> product = productRepository.findByTitle(title);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product :" + title +"  not found");
        }
        return product.get();
    }

    @Override
    public List<Product> getLimitedProducts(int limit) {
        return getAllProducts(limit, 0);
    }
    // Pagination and sorting, if sort is null, return all products, else return all products sorted by sort
    @Override
    public List<Product> getAllProductsAndSort(String sort) {
        if(sort == null){
            return productRepository.findAll();
        }
        Optional<List<Product>> productsList = productRepository.findAllAndSort(sort);
        if(productsList.isEmpty()){
            throw new ProductNotFoundException("No products found");
        }
        return productsList.get();
    }

    @Override
    public List<Product> getAllProductsAndSortAndLimit(String sort, Integer limit, Integer offset) {
        if(sort == null){
            return getAllProducts(limit, offset);
        }
        Optional<List<Product>> productsList = productRepository.findAllAndSort(sort);
        if(productsList.isEmpty()){
            throw new ProductNotFoundException("No products found");
        }
        return productsList.get();
    }

    @Override
    public Product createProduct(String title, String description, String imageURL, String categoryName, double amount, double discount, String currencyCode) {
        Price price = Price.builder().amount(amount).discount(discount).currencyCode(currencyCode).build();
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);
        if(categoryOptional.isEmpty()){
            throw new CategoryNotFoundException("Category " + categoryName + "not found, please create category first");
        }
        Category category = categoryOptional.get();
        Product product = Product.builder()
                .title(title)
                .description(description)
                .image(imageURL)
                .category(category)
                .price(price)
                .build();
        return productRepository.save(product);
    }
    // Implement this method to update the product with the given id, if the product is not found, return "Product not found", if category is not found, return "Category not found".
    // If the arguments are empty or null then don't update the product variables
    @Override
    public String updateProduct(UUID id, String title, String description, String imageURL, String category, double amount, double discount, String currencyCode) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }
        Product product = productOptional.get();
        if(title != null && !title.isEmpty()){
            product.setTitle(title);
        }
        if(description != null && !description.isEmpty()){
            product.setDescription(description);
        }
        if(imageURL != null && !imageURL.isEmpty()){
            product.setImage(imageURL);
        }
        if(category != null && !category.isEmpty()){
            Optional<Category> categoryOptional = categoryRepository.findByName(category);
            if(categoryOptional.isEmpty()){
                throw new CategoryNotFoundException("Category not found");
            }
            product.setCategory(categoryOptional.get());
        }
        if(amount != 0){
            product.getPrice().setAmount(amount);
        }
        if(discount != 0){
            product.getPrice().setDiscount(discount);
        }
        if(currencyCode != null && !currencyCode.isEmpty()){
            product.getPrice().setCurrencyCode(currencyCode);
        }
        productRepository.save(product);
        return "Product updated successfully";
    }
    // delete the product with the given id, if the product is not found, return "Product not found"
    @Override
    public String deleteProduct(UUID id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }
        productRepository.delete(productOptional.get());
        return "Product deleted successfully";
    }
}
