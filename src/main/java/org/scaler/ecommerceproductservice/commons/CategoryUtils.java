package org.scaler.ecommerceproductservice.commons;

import org.scaler.ecommerceproductservice.dtos.CategoryResponseDTO;
import org.scaler.ecommerceproductservice.models.Category;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
public class CategoryUtils {

    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category) {
        return CategoryResponseDTO.builder()
                .categoryName(category.getName())
                .build();
    }
}
