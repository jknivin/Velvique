package com.pillow.pillow.product.model;

import com.pillow.pillow.common.Model.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
@EqualsAndHashCode(callSuper = false)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotNull
    @Positive
    @Column(nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ProductImage> images = new ArrayList<>();

    public void addImage(ProductImage image){
        images.add(image);
        image.setProduct(this);
    }

    public void removeImage(ProductImage image){
        images.remove(image);
        image.setProduct(null);
    }

}
