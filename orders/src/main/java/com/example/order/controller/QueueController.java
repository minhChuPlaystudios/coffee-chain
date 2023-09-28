package com.example.order.controller;

import com.example.dto.order.OrderWaitingTimeDto;
import com.example.dto.order.WaitingOrderDto;
import com.example.dto.queue.QueueInfoDto;
import com.example.enums.OrderStatus;
import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@RestController
@RequestMapping("/queues")
public class QueueController {
    private OrderService orderService;

    @GetMapping(value = "/shops/{shopId}")
    public ResponseEntity<Collection<QueueInfoDto>> getOrdersInQueues(@PathVariable String shopId) {
        // TODO Get living queues from Redis by shopId
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/shops/{shopId}/serve")
    public ResponseEntity<WaitingOrderDto> pickOrderToServe(@PathVariable String shopId) {
        // Get the first order in queue from Redis and remove it from queue
        String orderId = "DummyOrderId";

        Order udpatedOrder = orderService.updateOrderStatus(orderId, OrderStatus.PREPARING);

        return new ResponseEntity<>(new WaitingOrderDto(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{userName}")
    public ResponseEntity<Collection<OrderWaitingTimeDto>> calculateWaitingTime(@PathVariable String userName) {
        List<Order> orders = orderService.findByOrderedByUser(userName);
        // TODO Get position of order in Queue based on queueId
        //  Calculate waiting time for each order
        return new ResponseEntity<>(orders.stream().map(Order::toOrderWaitingTimeDto).collect(Collectors.toList()), HttpStatus.OK);
    }


    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
