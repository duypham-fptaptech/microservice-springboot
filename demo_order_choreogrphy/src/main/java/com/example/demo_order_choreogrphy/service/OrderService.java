package com.example.demo_order_choreogrphy.service;

import com.example.demo_order_choreogrphy.entity.Order;
import com.example.demo_order_choreogrphy.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> findById(int id){
        return orderRepository.findById(id);
    }

    public Order save(Order order){
        orderRepository.save(order);
        return orderRepository.save(order);
    }
}
