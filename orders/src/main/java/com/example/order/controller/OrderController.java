package com.example.order.controller;

import com.example.dto.order.OrderDto;
import com.example.enums.OrderStatus;
import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable String orderId) {
        Order order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order.toOrderDto(), HttpStatus.OK);
    }

    @PatchMapping("/{orderId}/status/{toStatus}")
    public ResponseEntity<OrderDto> updateOrderStatus(@PathVariable String orderId, @PathVariable String toStatus) {
        OrderStatus toStatusEnum = OrderStatus.valueOf(toStatus);
        Order udpatedOrder = orderService.updateOrderStatus(orderId, toStatusEnum);
        if (OrderStatus.CANCELLED.equals(toStatusEnum)) {
            //TODO: Remove the order from the queue
        }

        return new ResponseEntity<>(udpatedOrder.toOrderDto(), HttpStatus.OK);
    }

    @GetMapping(value = "/findBy")
    public ResponseEntity<List<OrderDto>> findOrdersBy(@RequestParam(value = "shopId", required = false) String shopId, @RequestParam(value = "username", required = false) String username) {
        List<OrderDto> orders = orderService.findByOrderedByUserAndAtShopId(username, shopId).stream().map(Order::toOrderDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
