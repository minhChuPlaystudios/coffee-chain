package com.example.gatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @GetMapping("/shops")
    public String shopFallback() {
        return "Shops: Fallback";
    }

    @GetMapping("/users")
    public String userFallback() {
        return "Users: Fallback";
    }

    @GetMapping("/orders")
    public String orderFallback() {
        return "Orders: Fallback";
    }

    @GetMapping("/queues")
    public String queueFallback() {
        return "Queues: Fallback";
    }
}
