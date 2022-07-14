package com.example.demo_order_choreogrphy.repository;

import com.example.demo_order_choreogrphy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
