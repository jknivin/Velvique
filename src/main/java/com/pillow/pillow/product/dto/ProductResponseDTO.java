package com.pillow.pillow.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ProductResponseDTO {

    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private List<String> images;

}
