package com.example.demo_payment_choreogrphy.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payments") // Nếu ko cho thì tên default sẽ là Order
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String useName;
    private Integer wallet;
}
