package com.example.order.entity;

import com.example.dto.order.OrderDto;
import com.example.dto.order.OrderRequestDto;
import com.example.dto.order.OrderWaitingTimeDto;
import com.example.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Getter
@Setter
@Entity
@Table(name = "o_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String orderedByUser;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Date createdAt;
    private Date servedAt;

    private Integer atQueueId;

    private String atShopId;

    private String note;

    @Transient
    private List<OrderDetail> orderDetails;

    // toOrderDto
    public OrderDto toOrderDto() {
        OrderDto dto = new OrderDto();
        dto.setId(id.toString());
        dto.setOrderedByUser(orderedByUser);
        dto.setStatus(status.toString());
        dto.setCreatedAt(createdAt);
        dto.setServedAt(servedAt);
        dto.setAtQueueId(atQueueId);
        dto.setAtShopId(atShopId);
        dto.setNote(note);
        if (!orderDetails.isEmpty()) {
            dto.setOrderDetails(orderDetails.stream().map(OrderDetail::toOrderDetailDto).collect(Collectors.toList()));
        }
        return dto;
    }

    // Convert Order to OrderWaitingTimeDto
    public OrderWaitingTimeDto toOrderWaitingTimeDto() {
        OrderWaitingTimeDto dto = new OrderWaitingTimeDto();
        dto.setId(id.toString());
        dto.setOrderedByUser(orderedByUser);
        dto.setStatus(status);
        dto.setAtShopId(atShopId);
        dto.setNote(note);
        return dto;
    }

    public static Order fromOrderRequestDto(OrderRequestDto orderRequest) {
        Order order = new Order();
        order.setOrderedByUser(orderRequest.getOrderedByUser());
        order.setAtShopId(orderRequest.getAtShopId());
        order.setNote(orderRequest.getNote());
        order.setStatus(OrderStatus.READY);
        order.setCreatedAt(new Date());
        order.setOrderDetails(orderRequest.getOrderDetails().stream().map(OrderDetail::fromOrderDetailRequestDto).collect(Collectors.toList()));
        return order;
    }

}
