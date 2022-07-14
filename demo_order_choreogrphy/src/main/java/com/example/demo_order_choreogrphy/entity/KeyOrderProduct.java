package com.example.demo_order_choreogrphy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable // Được phép nhúng đi 1 thằng khác
public class KeyOrderProduct implements Serializable {
    private Integer orderId;
    private Integer productId;
}
