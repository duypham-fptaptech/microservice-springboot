package com.example.demo_order_choreogrphy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders") // Nếu ko cho thì tên default sẽ là Order
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String customerName;
    private Integer totalPrice;
    private Integer status;

    //2. Mối quan hệ giữa Order, OrderDetail
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;
}
