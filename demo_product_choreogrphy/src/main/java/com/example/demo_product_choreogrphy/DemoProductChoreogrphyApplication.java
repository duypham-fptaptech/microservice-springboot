package com.example.demo_product_choreogrphy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoProductChoreogrphyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProductChoreogrphyApplication.class, args);
	}

}
