package com.example.dto.order;

import com.example.dto.BaseDto;
import lombok.Data;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Data
public class OrderDetailRequestDto extends BaseDto {
    private String drinkId;
    private String drinkName;
    private Integer quantity;
    private Double price;
    private String note;
}
