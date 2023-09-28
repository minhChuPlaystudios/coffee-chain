package com.example.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayLocators(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("shop-service", r -> r.path("/shops/**").uri("lb://shop-service"))
                .route("user-service", r -> r.path("/users/**").uri("lb://user-service"))
                .route("order-service", r -> r.path("/orders/**").uri("lb://order-service"))
                .build();
    }
}
