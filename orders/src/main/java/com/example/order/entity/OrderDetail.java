package com.example.order.entity;

import com.example.dto.order.OrderDetailDto;
import com.example.dto.order.OrderDetailRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Getter
@Setter
@Entity
@Table(name = "o_order_detailss")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String drinkId;
    private String drinkName;

    private Integer quantity;

    private Double price;

    private String orderId;

    public OrderDetailDto toOrderDetailDto() {
        OrderDetailDto dto = new OrderDetailDto();
        dto.setId(id.toString());
        dto.setDrinkId(drinkId);
        dto.setDrinkName(drinkName);
        dto.setQuantity(quantity);
        dto.setPrice(price);
        dto.setOrderId(orderId);
        return dto;
    }

    public static OrderDetail fromOrderDetailRequestDto(OrderDetailRequestDto orderDetailRequest) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDrinkId(orderDetailRequest.getDrinkId());
        orderDetail.setDrinkName(orderDetailRequest.getDrinkName());
        orderDetail.setQuantity(orderDetailRequest.getQuantity());
        orderDetail.setPrice(orderDetailRequest.getPrice());
        return orderDetail;
    }
}
