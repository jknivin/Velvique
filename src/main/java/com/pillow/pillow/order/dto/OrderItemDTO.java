package com.pillow.pillow.order.dto;

import com.pillow.pillow.product.dto.ProductResponseDTO;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderItemDTO {

    private BigDecimal price;
    private Integer quantity;
    private ProductResponseDTO product;

}
