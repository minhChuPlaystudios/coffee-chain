package com.example.dto.order;

import com.example.dto.BaseDto;
import com.example.enums.OrderStatus;
import lombok.Data;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Data
public class OrderWaitingTimeDto extends BaseDto {
    private String id;
    private String atShopId;
    private String orderedByUser;
    private OrderStatus status;
    private String note;
    private Integer position;
    private Integer totalOrdersInQueue;
    private Long waitingTimeInMillis;
}
