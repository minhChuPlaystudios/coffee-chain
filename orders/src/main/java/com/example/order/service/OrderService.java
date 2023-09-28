package com.example.order.service;

import com.example.dto.order.OrderRequestDto;
import com.example.enums.OrderStatus;
import com.example.order.entity.Order;

import java.util.List;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
public interface OrderService {
    Order createOrder(OrderRequestDto orderRequest);

    Order getOrderById(String id);

    List<Order> findByShopId(String shopId);

    List<Order> findByOrderedByUser(String username);

    List<Order> findByOrderedByUserAndAtShopId(String username, String shopId);


    Order updateOrderStatus(String id, OrderStatus toStatus);
}
