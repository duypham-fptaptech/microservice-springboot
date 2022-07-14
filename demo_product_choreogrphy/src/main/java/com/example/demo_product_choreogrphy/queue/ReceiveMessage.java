package com.example.demo_product_choreogrphy.queue;


import com.example.demo_product_choreogrphy.entity.Product;
import com.example.demo_product_choreogrphy.queue.event.OrderDetailEvent;
import com.example.demo_product_choreogrphy.queue.event.OrderEvent;
import com.example.demo_product_choreogrphy.service.ProductService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.demo_product_choreogrphy.queue.Config.QUEUE_ORDER;

@Log4j2
@Component
public class ReceiveMessage {
//    @Autowired
//    OrderService orderService;

//    @Autowired
//    ConsumerService consumerService;

    @Autowired
    ProductService productService;

    @Autowired
    SendMessage sendMessage;

    @RabbitListener(queues = {QUEUE_ORDER})
    public void getMessage(String message) {
        log.info("nhan message " + message);
        Gson gson = new Gson();
        OrderEvent orderEvent = gson.fromJson(message, OrderEvent.class);

        for (OrderDetailEvent orderDetailEvent : orderEvent.getOrderDetailEvents()) {
            boolean checkProduct = productService.checkDeductProduct(orderDetailEvent.getProductId(), orderDetailEvent.getQuantity());
            if (!checkProduct){
                orderEvent.setStatus(-1);
                sendMessage.sendMessageOrder(gson.toJson(orderEvent));
                return;
            }
        }
        orderEvent.setStatus(2);
        sendMessage.sendMessagePayment(gson.toJson(orderEvent));
    }

}
