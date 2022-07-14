package com.example.demo_order_choreogrphy.controller;

import com.example.demo_order_choreogrphy.entity.DTO.CartItemDTO;
import com.example.demo_order_choreogrphy.entity.DTO.ProductDTO;
import com.example.demo_order_choreogrphy.entity.DTO.ShoppingCartDTO;
import com.example.demo_order_choreogrphy.entity.KeyOrderProduct;
import com.example.demo_order_choreogrphy.entity.Order;
import com.example.demo_order_choreogrphy.entity.OrderDetail;
import com.example.demo_order_choreogrphy.entity.Product;
import com.example.demo_order_choreogrphy.queue.ReceivedMessage;
import com.example.demo_order_choreogrphy.queue.SendMessage;
import com.example.demo_order_choreogrphy.queue.event.OrderEvent;
import com.example.demo_order_choreogrphy.repository.OrderRepository;
import com.example.demo_order_choreogrphy.repository.ProductRepository;
import com.example.demo_order_choreogrphy.service.OrderDetailService;
import com.example.demo_order_choreogrphy.service.OrderService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Log4j2
//@RequestMapping(path = "/api/v1/orders")
@CrossOrigin(origins = "*")
public class ShoppingCartController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    SendMessage sendMessage;

    @Autowired
    ReceivedMessage receivedMessage;

    @RequestMapping(method = RequestMethod.POST, path = "/shopping-cart")
    public ResponseEntity<?> saveCart(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        boolean hasException = false;
        /*
         * Truyền vào userId và danh sách sản phẩm trong shoppingCart
         * */

        /*
         * Đưa vào các trường trong ShoppingCart
         * */
        /*
         * Đưa vào các trường trong CartItem để đưa vào shoppingCart
         * */

        for (CartItemDTO cartItemDTO :
                shoppingCartDTO.getItems()) {

//            Gson productParser = new Gson();
//            Product product = new Product();
//            product.setId(cartItemDTO.getProductId());
//            product.setQuantity(cartItemDTO.getQuantity());
//            product.setPrice(cartItemDTO.getPrice());
//
//            String check = productParser.toJson(product);


//            Optional<Product> optionalProduct = productRepository.findById(cartItemDTO.getProductId());
//
//            if(!optionalProduct.isPresent()){
//                hasException = true;
//                break;
//            }
//            Product product = optionalProduct.get();


            shoppingCartDTO.addTotalPrice(cartItemDTO); // add tổng giá bigdecimal
        }

        Order order = new Order();
        order.setCustomerName(shoppingCartDTO.getUserName());
        order.setTotalPrice(shoppingCartDTO.getTotalPrice());
        order.setStatus(1);

        Order orderSave = orderService.save(order);
        Set<OrderDetail> orderDetails = new HashSet<>();
        for (CartItemDTO cartItemDTO : shoppingCartDTO.getItems()) {
            OrderDetail orderDetail = new OrderDetail();
            KeyOrderProduct keyOrderProduct = new KeyOrderProduct();
            keyOrderProduct.setOrderId(orderSave.getId());
            keyOrderProduct.setProductId(cartItemDTO.getProductId());

            orderDetail.setId(keyOrderProduct);

            Product product = productRepository.findById(cartItemDTO.getProductId()).orElse(null);
            if (product == null) {
                return new ResponseEntity("Co loi", HttpStatus.NOT_FOUND);
            }
            orderDetail.setOrder(orderSave);
            orderDetail.setProduct(product);

            orderDetail.setQuantity(cartItemDTO.getQuantity());
            orderDetail.setUnitPrice(cartItemDTO.getPrice());
            orderDetails.add(orderDetail);
        }

//        order.setOrderDetails((Set<OrderDetail>) orderDetailService.saveAll(orderDetails));
        order.setOrderDetails(orderDetails);
        Order orderCheckSave = orderService.save(order);
        OrderEvent orderEvent = new OrderEvent(orderCheckSave);
        Gson productParser = new Gson();
        String check = productParser.toJson(orderEvent);
        sendMessage.sendMessage(check);
        return ResponseEntity.ok(orderService.save(order));

    }

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

}
