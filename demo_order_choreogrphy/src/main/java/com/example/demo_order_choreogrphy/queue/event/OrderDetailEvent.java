package com.example.demo_order_choreogrphy.queue.event;

import com.example.demo_order_choreogrphy.entity.KeyOrderProduct;
import com.example.demo_order_choreogrphy.entity.Order;
import com.example.demo_order_choreogrphy.entity.OrderDetail;
import com.example.demo_order_choreogrphy.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEvent {
    private Integer quantity;
    private Integer unitPrice;
    private Integer productId;

    public OrderDetailEvent(OrderDetail orderDetail) {
        this.quantity = orderDetail.getQuantity();
        this.unitPrice = orderDetail.getUnitPrice();
        this.productId = orderDetail.getId().getProductId();
    }
}
