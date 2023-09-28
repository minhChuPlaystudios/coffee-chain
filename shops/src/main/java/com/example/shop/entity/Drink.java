package com.example.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author minh.chu
 * @since 19/09/2023
 */

@Data
@Entity
@Table(name = "s_drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String shopId;
    private String name;
    private Double price;
}
