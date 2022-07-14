package com.example.demo_order_choreogrphy.entity;

import com.example.demo_order_choreogrphy.entity.DTO.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_details")
public class OrderDetail {
    @EmbeddedId // Composite Key (là khóa chính được tạo từ 2 trường)
    private KeyOrderProduct id ;

//    private Integer productId;
//
//    private Integer orderId;

    private Integer quantity;
    private Integer unitPrice;

    //2. mối quan hệ giữa OrderDetail và Order

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId",updatable = false,insertable = false)
    @JsonIgnore
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId",updatable = false,insertable = false)
    @JsonIgnore
    private Product product;


}
