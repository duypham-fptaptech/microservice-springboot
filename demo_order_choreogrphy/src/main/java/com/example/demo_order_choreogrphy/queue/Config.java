package com.example.demo_order_choreogrphy.queue;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
public class Config {

    public static final String DIRECT_EXCHANGE = "direct.exchange";

    public static final String QUEUE_ORDER = "direct.queue.order";
    public static final String QUEUE_PRODUCT_TO_ORDER = "direct.queue.product_to_order";
    public static final String QUEUE_PAYMENT_TO_ORDER = "direct.queue.payment_to_order";



    public static final String DIRECT_ROUTING_KEY_ORDER = "direct.routingKeyOrder";
    public static final String DIRECT_ROUTING_KEY_PRODUCT_TO_ORDER = "direct.routingKeyProductToOrder";
    public static final String DIRECT_ROUTING_KEY_PAYMENT_TO_ORDER = "direct.routingKeyPaymentToOrder";


    @Bean
    public Declarables binding() {
        Queue directQueueOrder = new Queue(QUEUE_ORDER);
        Queue directQueueProductToOrder = new Queue(QUEUE_PRODUCT_TO_ORDER);
        Queue directQueuePaymentToOrder = new Queue(QUEUE_PAYMENT_TO_ORDER);

        DirectExchange directExchange = new DirectExchange(DIRECT_EXCHANGE);
        return new Declarables(
                directQueueOrder,
                directQueueProductToOrder,
                directQueuePaymentToOrder,
                directExchange,
                bind(directQueueOrder).to(directExchange).with(DIRECT_ROUTING_KEY_ORDER),
                bind(directQueueProductToOrder).to(directExchange).with(DIRECT_ROUTING_KEY_PRODUCT_TO_ORDER),
                bind(directQueuePaymentToOrder).to(directExchange).with(DIRECT_ROUTING_KEY_PAYMENT_TO_ORDER)

//                bind(directQueuePay).to(directExchange).with(DIRECT_ROUTING_KEY_PAY),
//                bind(directQueueInventory).to(directExchange).with(DIRECT_ROUTING_KEY_INVENTORY),
//
//                bind(directQueuePay).to(directExchange).with(DIRECT_SHARE_ROUTING_KEY),
//                bind(directQueueInventory).to(directExchange).with(DIRECT_SHARE_ROUTING_KEY)
        );
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}