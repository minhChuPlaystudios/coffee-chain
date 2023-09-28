package com.example.order.repository;

import com.example.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByAtShopId(String shopId);

    List<Order> findByOrderedByUser(String username);

    List<Order> findByOrderedByUserAndAtShopId(String username, String shopId);
}
