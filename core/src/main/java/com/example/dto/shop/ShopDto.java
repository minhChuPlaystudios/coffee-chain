package com.example.dto.shop;

import com.example.dto.BaseDto;
import com.example.dto.queue.QueueInfoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDto extends BaseDto {
    private Integer id;
    private String name;
    private List<QueueInfoDto> queueInfos;
}
