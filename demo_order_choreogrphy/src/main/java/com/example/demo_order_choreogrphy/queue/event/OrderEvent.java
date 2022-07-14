package com.example.demo_order_choreogrphy.queue.event;

import com.example.demo_order_choreogrphy.entity.Order;
import com.example.demo_order_choreogrphy.entity.OrderDetail;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {
    private Integer id;
    private String customerName;
    private Integer totalPrice;
    private Integer status;
    private Set<OrderDetailEvent> orderDetailEvents;

    public OrderEvent(Order order) {
        this.id = order.getId();
        this.customerName = order.getCustomerName();
        this.totalPrice = order.getTotalPrice();
        this.status = order.getStatus();
        Set<OrderDetailEvent> orderDetailEvents = new HashSet<>();
        for (OrderDetail orderDetail :order.getOrderDetails()) {
            orderDetailEvents.add(new OrderDetailEvent(orderDetail));
        }
        this.orderDetailEvents = orderDetailEvents;

    }
}
