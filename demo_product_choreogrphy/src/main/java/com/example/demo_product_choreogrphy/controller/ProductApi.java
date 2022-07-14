package com.example.demo_product_choreogrphy.controller;

import com.example.demo_product_choreogrphy.entity.Product;
import com.example.demo_product_choreogrphy.repository.ProductRepository;
import com.example.demo_product_choreogrphy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("api/v1/product")
public class ProductApi {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

//    @RequestMapping(value = "/deductProduct", method = RequestMethod.POST)
//    public ResponseEntity<?> deductProduct(
//            @RequestBody Product product
//            ) {
//        return new ResponseEntity(productService.deductProduct(product), HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.GET, path = "/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }
}
