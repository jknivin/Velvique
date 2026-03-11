package com.pillow.pillow.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ProductResponseDTO {

    private UUID id;
    private String title;
    private String description;
    private Integer price;
    private List<String> images;

}
