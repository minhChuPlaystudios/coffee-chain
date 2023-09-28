package com.example.order.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@FeignClient(name = "shop-service")
public interface ShopClientApi {
}
