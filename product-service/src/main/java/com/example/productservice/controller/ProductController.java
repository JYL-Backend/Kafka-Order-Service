package com.example.productservice.controller;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-service")
public class ProductController {
    final private ProductService productService;
    @GetMapping("/product/{code}")
    public ProductDto getProduct(@PathVariable("code") String code){
        return productService.findByCode(code);
    }

    @PostMapping("/product")
    public Long createProduct(@RequestBody ProductDto dto){
        return productService.createProduct(dto);
    }

}
