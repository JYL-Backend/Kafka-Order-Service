package com.example.productservice.repository;

import com.example.productservice.entity.ProductEntity;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static com.example.productservice.entity.QProductEntity.productEntity;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom{


    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public ProductEntity findByCode(String code) {
//        return null;
        List<ProductEntity> result = jpaQueryFactory.selectFrom(productEntity)
                .where(productEntity.code.eq(code))
                .fetch();

        return result.get(0);
    }
}
