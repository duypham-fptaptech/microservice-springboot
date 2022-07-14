package com.example.demo_product_choreogrphy.queue.event;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEvent {
    private Integer quantity;
    private Integer unitPrice;
    private Integer productId;
}
