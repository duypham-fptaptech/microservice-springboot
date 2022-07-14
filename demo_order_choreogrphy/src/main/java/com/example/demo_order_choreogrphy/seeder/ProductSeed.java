package com.example.demo_order_choreogrphy.seeder;

import com.example.demo_order_choreogrphy.entity.Product;
import com.example.demo_order_choreogrphy.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class ProductSeed implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("American Marigold", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1655887621/9_szbohs.jpg", 1, 11000, 1));
        products.add(new Product("Black Eyed Susan", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1655887630/20_bcm5ve.jpg", 1, 25000, 1));
        products.add(new Product("Bleeding Heart", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1655887643/7_w0rntk.jpg", 1, 37000, 1));
        products.add(new Product("Bloody Cranesbill", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1655887657/35_l20daj.jpg", 1, 24000, 1));
        products.add(new Product("Common Yarrow", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1656490476/11_xnsz6i.jpg", 1, 46000, 1));
        products.add(new Product("Doublefile Viburnum", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1656490494/3_asmhvj.jpg", 1, 55000, 1));
        products.add(new Product("Feather Reed Grass", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1656490498/2_fiubgy.jpg", 1, 48000, 1));
        products.add(new Product("Moss Verbena", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1656490504/24_kail9i.jpg", 1, 39000, 1));
        products.add(new Product("Million Gold", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1656490509/21_oasmcb.jpg", 1, 27000, 1));
        products.add(new Product("Hybrid Pansy", "https://res.cloudinary.com/dm2gtzw6g/image/upload/v1656490518/22_rl2mor.jpg", 1, 100000, 1));
//        productRepository.saveAll(products);
    }
}
