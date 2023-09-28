package com.example.dto.order;

import com.example.dto.BaseDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Data
public class OrderDto extends BaseDto {
    private String id;
    private String orderedByUser;
    private String status;

    private Date createdAt;
    private Date servedAt;

    private Integer atQueueId;

    private String atShopId;

    private String note;

    private List<OrderDetailDto> orderDetails;
}
