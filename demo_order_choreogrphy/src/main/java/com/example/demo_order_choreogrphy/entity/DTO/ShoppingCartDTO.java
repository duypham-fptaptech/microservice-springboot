package com.example.demo_order_choreogrphy.entity.DTO;

import com.example.demo_order_choreogrphy.entity.Product;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class ShoppingCartDTO {
    private String userName; // ai tạo
//    private Integer totalPrice;
//    private String shipName;
//    private String shipAddress;
//    private String shipPhone;
//    private String shipNote;
    private Set<CartItemDTO> items;
    private Integer totalPrice;

//    public ShoppingCart generateCart(){
//        return new ShoppingCart();
//    }
    public void addTotalPrice(CartItemDTO cartItem) {
        if(this.totalPrice == null){
            this.totalPrice = 0;
        }
//        log.info("CartItem getUnitPrice: " + cartItem.getPrice());
//        log.info("CartItem getQuantity: " + cartItem.getQuantity());
        this.totalPrice += (cartItem.getPrice() * cartItem.getQuantity());
//        log.info("totalPrice CartItem: " + this.totalPrice);

    }
}
