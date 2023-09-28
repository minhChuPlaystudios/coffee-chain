package com.example.dto.order;

import com.example.dto.BaseDto;
import lombok.Data;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Data
public class WaitingOrderDto extends BaseDto {
    private String orderId;
    private String orderedByUser;
}
