package com.example.apigatewaydemo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public RouteLocator gatewayLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("orders-service", r -> r.path("/api/v1/orders/**")
                        .filters(f -> f.rewritePath("/api/v1/orders/(?<remains>.*)", "/${remains}"))
                        .uri("lb://ORDERS-SERVICE/")
                )
                .route("products-service", r -> r.path("/api/v1/products/**")
                        .filters(f -> f.rewritePath("/api/v1/products/(?<remains>.*)", "/${remains}"))
                        .uri("lb://PRODUCTS-SERVICE")
                )
                .build();
    }
}
