package com.example.demo_order_choreogrphy.service;

import com.example.demo_order_choreogrphy.entity.KeyOrderProduct;
import com.example.demo_order_choreogrphy.entity.Order;
import com.example.demo_order_choreogrphy.entity.OrderDetail;
import com.example.demo_order_choreogrphy.entity.Product;
import com.example.demo_order_choreogrphy.repository.OrderDetailRepository;
import com.example.demo_order_choreogrphy.repository.OrderRepository;
import com.example.demo_order_choreogrphy.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Log4j2
@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

//    public OrderDetail save(OrderDetail orderDetail){
//        Optional<Product> optionalProduct = productRepository.findById(orderDetail.getProductId());
////        log.info("check getOrderId " + orderDetail.getOrderId());
////        log.info("check getProductId " + orderDetail.getProductId());
////        log.info("check optionalProduct " + optionalProduct.isPresent());
//        Optional<Order> optionalOrder = orderRepository.findById(orderDetail.getOrderId());
//
//        if (optionalProduct.isPresent() && optionalOrder.isPresent()){
//            orderDetail.setProduct(optionalProduct.get());
//            orderDetail.setOrder(optionalOrder.get());
////            log.info("check getProductId " + orderDetail.getProductId());
////            log.info("check getOrderId again: " + orderDetail.getOrderId());
//
//            KeyOrderProduct course = new KeyOrderProduct(orderDetail.getProductId(),orderDetail.getOrderId());
//            orderDetail.setId(course);
//
//            orderDetailRepository.save(orderDetail);
//        }
//
//        return orderDetail;
//    }

    public List<OrderDetail> saveAll(List<OrderDetail> orderDetails){
        log.info("check orderDetails test la " + orderDetails);
        return  orderDetailRepository.saveAll(orderDetails);
    }
}
