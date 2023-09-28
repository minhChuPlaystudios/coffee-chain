package com.example.order.repository;

import com.example.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {

    List<OrderDetail> findByOrderId(String id);

    List<OrderDetail> findByOrderIdIn(Set<String> ids);
}
