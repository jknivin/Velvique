package com.pillow.pillow.product.service;

import com.pillow.pillow.product.dto.ProductRequestDTO;
import com.pillow.pillow.product.dto.ProductResponseDTO;
import com.pillow.pillow.product.exception.ProductNotFoundException;
import com.pillow.pillow.product.mapper.ProductMapper;
import com.pillow.pillow.product.model.Product;
import com.pillow.pillow.product.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductResponseDTO addProduct(ProductRequestDTO data){

        Product product = ProductMapper.toEntity(data);

        Product savedProduct = productRepository.save(product);

        return ProductMapper.toResponse(savedProduct);
    }

    public List<ProductResponseDTO> getProducts(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable)
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    public ProductResponseDTO getProductById(UUID id){
        Product data = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("No product found with id "+id));

        return ProductMapper.toResponse(data);
    }

}
