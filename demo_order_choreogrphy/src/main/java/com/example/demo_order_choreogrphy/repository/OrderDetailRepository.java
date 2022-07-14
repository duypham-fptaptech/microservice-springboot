package com.example.demo_order_choreogrphy.repository;

import com.example.demo_order_choreogrphy.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer>{
}
