package com.example.dto.queue;

import com.example.dto.BaseDto;
import lombok.Data;

/**
 * @author minh.chu
 * @since 21/09/2023
 */

@Data
public class QueueConfigDto extends BaseDto {
    private String shopId;
    private Integer maxOrdersPerQueue;
    private Integer maxQueueSize;
}
