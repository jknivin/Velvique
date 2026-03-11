package com.pillow.pillow.product.mapper;

import com.pillow.pillow.product.DTO.ProductRequestDTO;
import com.pillow.pillow.product.DTO.ProductResponseDTO;
import com.pillow.pillow.product.model.Product;
import com.pillow.pillow.product.model.ProductImage;

public class ProductMapper {

    public static Product toEntity(ProductRequestDTO data){
        Product product = new Product();
        product.setTitle(data.getTitle());
        product.setDescription(data.getDescription());
        product.setPrice(data.getPrice());
        if(data.getImages() != null){
            data.getImages().forEach(url -> {
                ProductImage image = new ProductImage();
                image.setImageUrl(url);
                product.addImage(image);
            });
        }

        return product;
    }

    public static ProductResponseDTO toResponse(Product data){
        return new ProductResponseDTO(
                data.getId(),
                data.getTitle(),
                data.getDescription(),
                data.getPrice(),
                data.getImages().stream().map(ProductImage::getImageUrl).toList()
                );
    }

}
