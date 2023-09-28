package com.example.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Currency;
import java.util.UUID;

/**
 * @author minh.chu
 * @since 19/09/2023
 */

@Data
@Entity
@Table(name = "s_shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @JsonIgnore
    private UUID ownerId;
    private String name;
    private LocalTime openingTime;
    private LocalTime closingTime;
    @JsonIgnore
    private Integer maxOrdersPerQueue;
    @JsonIgnore
    private Integer maxQueueSize;
    @JsonIgnore
    private Currency currency;
    private String contact;
    private Point point;

}
