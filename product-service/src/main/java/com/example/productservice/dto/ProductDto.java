package com.example.productservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private String name;
    private String code;
    private long amount;
}
