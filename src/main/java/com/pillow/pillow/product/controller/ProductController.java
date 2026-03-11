package com.pillow.pillow.product.controller;

import com.pillow.pillow.common.dto.GlobalResponseDTO;
import com.pillow.pillow.product.dto.ProductRequestDTO;
import com.pillow.pillow.product.dto.ProductResponseDTO;
import com.pillow.pillow.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<GlobalResponseDTO<ProductResponseDTO>> addProduct(@Valid @RequestBody ProductRequestDTO data){
        return ResponseEntity.status(201)
                .body(new GlobalResponseDTO<>(201,"Product added successfully",
                        productService.addProduct(data)));
    }

    @GetMapping
    public ResponseEntity<GlobalResponseDTO<List<ProductResponseDTO>>> getProduct(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(new GlobalResponseDTO<>(200,"Products Fetched Successfully" ,
                productService.getProducts(page , size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponseDTO<ProductResponseDTO>> getProductById(@PathVariable UUID id){
        return ResponseEntity.ok(new GlobalResponseDTO<>(200,"Product fetched successfully fetched with id "+id,
                productService.getProductById(id)));
    }
}
