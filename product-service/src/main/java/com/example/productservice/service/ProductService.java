package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.entity.ProductEntity;

public interface ProductService {
    ProductDto findByCode(String code);

    default ProductDto entityToDto(ProductEntity entity) {
        return ProductDto.builder()
                .code(entity.getCode())
                .name(entity.getName())
                .amount(entity.getAmount())
                .build();
    }

    default ProductEntity dtoToEntity(ProductDto dto){
        return ProductEntity.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .code(dto.getCode())
                .build();
    }

    Long createProduct(ProductDto dto);
}
