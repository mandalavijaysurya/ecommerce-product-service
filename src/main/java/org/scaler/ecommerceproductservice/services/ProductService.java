package org.scaler.ecommerceproductservice.services;

import org.scaler.ecommerceproductservice.models.Product;

import java.awt.color.ProfileDataException;
import java.net.Inet4Address;
import java.util.List;
import java.util.UUID;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public interface ProductService {
    List<Product> getAllProducts(Integer limit, Integer offset);
    Product getProduct(String title);
    List<Product> getLimitedProducts(int limit);
    List<Product>  getAllProductsAndSort(String sort);
    List<Product> getAllProductsAndSortAndLimit(String sort, Integer limit, Integer offset);
    Product createProduct(String title, String description, String imageURL, String categoryName, double amount, double discount, String currencyCode);
    String updateProduct(UUID id, String title, String description, String imageURL, String category, double amount, double discount, String currencyCode);
    String deleteProduct(UUID id);
}
