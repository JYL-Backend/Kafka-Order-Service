package com.example.productservice.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class ProductEntity {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private Long amount;
    private String code;
}
