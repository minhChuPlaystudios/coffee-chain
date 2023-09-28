package com.example.shop.repository;

import com.example.shop.entity.Shop;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop, UUID> {
    List<Shop> findLocationsWithinRadius(Point point, Distance radius);
}
