package com.pillow.pillow.product.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductRequestDTO {

    private String title;
    private String description;
    private Integer price;
    private List<String> images;

}
