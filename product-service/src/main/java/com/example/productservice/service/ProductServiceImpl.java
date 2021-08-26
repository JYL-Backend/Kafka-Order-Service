package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.entity.ProductEntity;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    final private ProductRepository productRepository;

    @Override
    public ProductDto findByCode(String code) {
        return entityToDto(productRepository.findByCode(code));
    }

    @Override
    public Long createProduct(ProductDto dto) {
         productRepository.save(dtoToEntity(dto));
        return productRepository.save(dtoToEntity(dto)).getId();
    }

}
