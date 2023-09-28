package com.example.dto.queue;

import com.example.dto.BaseDto;
import com.example.dto.order.WaitingOrderDto;
import lombok.Data;

import java.util.List;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Data
public class QueueInfoDto extends BaseDto {
    private Integer id;
    private Integer maxSize;
    private Integer currentWaitingCustomers;
    private List<WaitingOrderDto> waitingOrders;
}
