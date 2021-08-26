package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.entity.ProductEntity;

public interface ProductService {
    ProductDto findByCode(String code);

    default ProductDto entityToDto(ProductEntity entity) {
        return ProductDto.builder()
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }
}
