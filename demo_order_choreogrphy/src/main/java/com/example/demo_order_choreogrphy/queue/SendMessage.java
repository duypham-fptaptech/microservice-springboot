package com.example.demo_order_choreogrphy.queue;

import com.example.demo_order_choreogrphy.entity.DTO.ProductDTO;
import com.example.demo_order_choreogrphy.entity.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo_order_choreogrphy.queue.Config.DIRECT_EXCHANGE;
import static com.example.demo_order_choreogrphy.queue.Config.DIRECT_ROUTING_KEY_ORDER;

@Service
@Log4j2
public class SendMessage {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
//        rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, DIRECT_ROUTING_KEY_PAY, new OrderEvent(order));
        rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, DIRECT_ROUTING_KEY_ORDER, message);
        log.info("gui message: " + message);
    }

}
