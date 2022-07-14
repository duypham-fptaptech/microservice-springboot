package com.example.demo_order_choreogrphy.queue;

import com.example.demo_order_choreogrphy.entity.Order;
import com.example.demo_order_choreogrphy.queue.event.OrderEvent;
import com.example.demo_order_choreogrphy.service.OrderService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.demo_order_choreogrphy.queue.Config.QUEUE_PAYMENT_TO_ORDER;
import static com.example.demo_order_choreogrphy.queue.Config.QUEUE_PRODUCT_TO_ORDER;

@Log4j2
@Component
public class ReceivedMessage {
    @Autowired
    OrderService orderService;

    @RabbitListener(queues = {QUEUE_PRODUCT_TO_ORDER})
    public void getMessageProduct(String message) {
        log.info("Nhan orderEvent ben product la" + message);
        Gson gson = new Gson();
        OrderEvent orderEvent = gson.fromJson(message, OrderEvent.class);
//        if (orderEvent.getStatus() == 2){
//            Order order = orderService.findById(orderEvent.getId()).orElse(null);
//            if (order != null){
//                order.setStatus(orderEvent.getStatus());
//                orderService.save(order);
//                return;
//            }
//        }
//        if (orderEvent.getStatus() == -1){
//
//        }
        Order order = orderService.findById(orderEvent.getId()).orElse(null);
        if (order != null){
            if (orderEvent.getStatus() == -1) {
                order.setStatus(orderEvent.getStatus());
                orderService.save(order);
            }
        }
    }

    @RabbitListener(queues = {QUEUE_PAYMENT_TO_ORDER})
    public void getMessagePayment(String message){
        log.info("Nhan orderEvent ben payment la" + message);
        Gson gson = new Gson();
        OrderEvent orderEvent = gson.fromJson(message, OrderEvent.class);
        Order order = orderService.findById(orderEvent.getId()).orElse(null);
        if (order != null){
            order.setStatus(orderEvent.getStatus());
            orderService.save(order);
            return;
        }
    }
}
