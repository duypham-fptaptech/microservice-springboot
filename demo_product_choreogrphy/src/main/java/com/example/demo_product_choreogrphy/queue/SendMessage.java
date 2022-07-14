package com.example.demo_product_choreogrphy.queue;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo_product_choreogrphy.queue.Config.*;

@Service
@Log4j2
public class SendMessage {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessageOrder(String message){
        rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, DIRECT_ROUTING_KEY_PRODUCT_TO_ORDER, message);

        log.info("gui message order: " + message);
    }

    public void sendMessagePayment(String message){
        rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, DIRECT_ROUTING_KEY_PRODUCT_TO_PAYMENT, message);

        log.info("gui message payment: " + message);
    }
}
