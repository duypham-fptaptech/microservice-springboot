package com.example.demo_product_choreogrphy.until;

import com.example.demo_product_choreogrphy.entity.Product;
import com.google.gson.Gson;
import com.rabbitmq.client.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Log4j2
@Component
public class QueueService {

    Product product = new Product();
    private final static String QUEUE_Product = "order_product";
    private final static String QUEUE_Product_Error = "product_error";

    // nhận từ order thông qua queue để check số lượng sản phẩm
    public Product received() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = null;
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_Product,
                    false, false,false, null);

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body)
                        throws IOException {
                    Gson gson = new Gson();

                    String message = new String(body, "UTF-8");
                    product = gson.fromJson(message,Product.class);

                    log.info("Product Recieved' " + product.getName() + "'");
                }
            };
            channel.basicConsume(QUEUE_Product, true, consumer);
            channel.close();
            connection.close();
            return product;
        } catch (Exception e) {
            log.info("Product Recieved error:  " + e.getMessage());
            return null;
        }
    }

    // trả về cho order với thông tin
    public void sender(Product product) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = null;
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_Product,
                    false,
                    false,
                    false,
                    null);
            Gson gson = new Gson();
            String message = gson.toJson(product);

            channel.basicPublish("",
                    QUEUE_Product,
                    null,
                    message.getBytes("UTF-8"));

            channel.close();
            connection.close();
        } catch (Exception e) {
            log.info("Product Send error:  " + e.getMessage());
        }
    }

    // gửi lỗi
    public void senderError(String error){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = null;
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_Product_Error,
                    false,
                    false,
                    false,
                    null);

            channel.basicPublish("",
                    QUEUE_Product_Error,
                    null,
                    error.getBytes("UTF-8"));

            channel.close();
            connection.close();
        } catch (Exception e) {
            log.info("Product Recieved error:  " + e.getMessage());
        }
    }


}
