package com.example.demo_product_choreogrphy.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products") // Nếu ko cho thì tên default sẽ là Order
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String image;
    private Integer quantity;
    private Integer price;
    private Integer status;

    public Product(String name, String image, Integer quantity, Integer price, Integer status) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }
}
