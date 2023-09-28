package com.example.order.service;

import com.example.dto.order.OrderRequestDto;
import com.example.enums.OrderStatus;
import com.example.order.entity.Order;
import com.example.order.entity.OrderDetail;
import com.example.order.repository.OrderDetailRepository;
import com.example.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepo;

    private OrderDetailRepository orderDetailRepo;

    @Override
    public Order createOrder(OrderRequestDto orderRequest) {
        return orderRepo.save(Order.fromOrderRequestDto(orderRequest));
    }

    @Override
    public Order getOrderById(String id) {
        Order order = orderRepo.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Order not found for this orderId : " + id));
        List<OrderDetail> orderDetails = orderDetailRepo.findByOrderId(order.getId().toString());
        order.setOrderDetails(orderDetails);
        return order;
    }

    public List<Order> findByOrderedByUser(String username) {
        return orderRepo.findByOrderedByUser(username);
    }

    @Override
    public List<Order> findByShopId(String shopId) {
        List<Order> orders = orderRepo.findByAtShopId(shopId);

        Set<String> orderIds = orders.stream().map(Order::getId).map(UUID::toString).collect(Collectors.toSet());
        Map<String, List<OrderDetail>> orderDetailsByOrder = orderDetailRepo.findByOrderIdIn(orderIds).stream()
                .collect(Collectors.groupingBy(OrderDetail::getOrderId));

        for (Order order : orders) {
            order.setOrderDetails(orderDetailsByOrder.get(order.getId().toString()));
        }
        return orders;
    }

    @Override
    public List<Order> findByOrderedByUserAndAtShopId(String username, String shopId) {
        List<Order> orders = orderRepo.findByOrderedByUserAndAtShopId(username, shopId);
        Set<String> orderIds = orders.stream().map(Order::getId).map(UUID::toString).collect(Collectors.toSet());
        Map<String, List<OrderDetail>> orderDetailsByOrder = orderDetailRepo.findByOrderIdIn(orderIds).stream()
                .collect(Collectors.groupingBy(OrderDetail::getOrderId));

        for (Order order : orders) {
            order.setOrderDetails(orderDetailsByOrder.get(order.getId().toString()));
        }
        return orders;
    }

    @Override
    public Order updateOrderStatus(String orderId, OrderStatus toStatus) {
        Order order = orderRepo.findById(UUID.fromString(orderId)).orElse(null);
        if (order == null) {
            throw new RuntimeException("Order not found for this orderId: " + orderId);
        }
        order.setStatus(toStatus);
        return orderRepo.save(order);

    }

    @Autowired
    public void setOrderRepo(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Autowired
    public void setOrderDetailRepo(OrderDetailRepository orderDetailRepo) {
        this.orderDetailRepo = orderDetailRepo;
    }
}
