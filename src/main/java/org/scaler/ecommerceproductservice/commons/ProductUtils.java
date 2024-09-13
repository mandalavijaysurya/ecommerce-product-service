package org.scaler.ecommerceproductservice.commons;

import org.scaler.ecommerceproductservice.dtos.ProductListResponseDTO;
import org.scaler.ecommerceproductservice.dtos.ProductResponseDTO;
import org.scaler.ecommerceproductservice.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public class ProductUtils {

    public static ProductResponseDTO convertProductToProductResponseDTO(Product product) {
        return ProductResponseDTO.builder()
                .productCategory(product.getCategory().getName())
                .productImageURL(product.getImage())
                .productPrice(product.getPrice().getCurrencyCode() + " " + getPrice(product.getPrice().getAmount(), product.getPrice().getDiscount()))
                .build();
    }

    private static double getPrice(double amount, double discount) {
        return amount * (1 - discount / 100);
    }

    public static ProductListResponseDTO convertProductListToProductListResponseDTO(List<Product> products) {
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for(Product prod : products) {
            productResponseDTOs.add(convertProductToProductResponseDTO(prod));
        }
        return ProductListResponseDTO.builder()
                .productResponse(productResponseDTOs)
                .build();
    }
}
