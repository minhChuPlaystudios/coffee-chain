package com.example.shop.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@FeignClient(name = "order-service")
public interface OrderClientApi {
}
