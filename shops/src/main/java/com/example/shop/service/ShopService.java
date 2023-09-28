package com.example.shop.service;


import com.example.shop.entity.Shop;
import org.springframework.data.geo.Point;

import java.util.List;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
public interface ShopService {

    List<Shop> findShopNearBy(Point point);

    Shop findShopById(String id);

    List<Shop> findAll();
}
