package com.example.productservice.repository;

import com.example.productservice.entity.ProductEntity;

public interface ProductRepositoryCustom {
    ProductEntity findByCode(String code);
}
