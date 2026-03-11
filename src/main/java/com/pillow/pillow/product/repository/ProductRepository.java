package com.pillow.pillow.product.repository;

import com.pillow.pillow.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("""
        select p FROM Product p
        LEFT JOIN FETCH p.images
    """)
    List<Product> findAllWithImages();
}
