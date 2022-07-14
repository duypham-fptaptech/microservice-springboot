package com.example.demo_order_choreogrphy.repository;

import com.example.demo_order_choreogrphy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
