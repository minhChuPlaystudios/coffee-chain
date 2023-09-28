package com.example.order.stream;

import com.example.dto.order.OrderRequestDto;
import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Service
public class OrderStreamHandler {
    private OrderService orderService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "orderRequest", durable = "true", arguments = @Argument(name = "x-message-ttl", value = "5000", type = "java.lang.Integer")),
            exchange = @Exchange(value = "orderExchange", type = "topic"),
            key = "#.orderRequest.#")
    )
    public void handleOrderRequest(OrderRequestDto orderRequest) {
        Order order = orderService.createOrder(orderRequest);
        // Can send response back to a queue if needed
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
