package com.example.demo_product_choreogrphy.queue.event;

import lombok.*;

import java.util.HashSet;
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

}
