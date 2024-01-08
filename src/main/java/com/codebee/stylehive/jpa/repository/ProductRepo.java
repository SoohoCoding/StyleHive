package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
}
