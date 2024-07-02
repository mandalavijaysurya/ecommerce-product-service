package org.scaler.ecommereceproductservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Builder
@Getter
@Setter
public class FakeStoreProductListResponseDTO {
    private List<FakeStoreProductResponseDTO> fakeStoreProductListResponseDTO;
}
