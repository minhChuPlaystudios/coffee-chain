package com.example.dto.order;

import com.example.dto.BaseDto;
import lombok.Data;

import java.util.List;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Data
public class OrderRequestDto extends BaseDto {
    private String orderedByUser;

    private String atShopId;

    private String note;

    private List<OrderDetailRequestDto> orderDetails;
}
