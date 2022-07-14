package com.example.demo_product_choreogrphy.service;

import com.example.demo_product_choreogrphy.entity.Product;
import com.example.demo_product_choreogrphy.enumEntity.ErrorEnum;
import com.example.demo_product_choreogrphy.queue.event.OrderDetailEvent;
import com.example.demo_product_choreogrphy.repository.ProductRepository;
import com.example.demo_product_choreogrphy.until.QueueService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    QueueService queueService;

    // check và trừ sản phẩm
    public boolean checkDeductProduct (Integer productIdCheck, Integer quantity){
        Product product = productRepository.findById(productIdCheck).orElse(null);
        if (product == null){
            return false;
        }

        if (product.getQuantity() <0){
            return false;
        }

        Integer quantityCheck = product.getQuantity() - quantity;
        if (quantityCheck < 0){
            return false;
        }
        return deductProduct(productIdCheck,quantity);
    }

    public boolean deductProduct (Integer productIdCheck, Integer quantity){
        try{
            Product product = productRepository.findById(productIdCheck).orElse(null);
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

}
