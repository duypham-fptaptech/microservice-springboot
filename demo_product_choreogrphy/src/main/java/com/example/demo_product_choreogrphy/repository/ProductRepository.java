package com.example.demo_product_choreogrphy.repository;

import com.example.demo_product_choreogrphy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
