package com.example.shop.service;

import com.example.shop.entity.Shop;
import com.example.shop.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Slf4j
@Service
public class ShopServiceImpl implements ShopService {
    private static final double RADIUS = 1;
    private ShopRepository shopRepo;

    @Override
    public List<Shop> findShopNearBy(Point point) {
        return shopRepo.findLocationsWithinRadius(point, new Distance(RADIUS));
    }

    @Override
    public Shop findShopById(String id) {
        return shopRepo.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public List<Shop> findAll() {
        return shopRepo.findAll();
    }

    @Autowired
    public void setShopRepo(ShopRepository shopRepo) {
        this.shopRepo = shopRepo;
    }
}
