package com.example.demo_order_choreogrphy.entity.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer price;
    private Integer status;
}
