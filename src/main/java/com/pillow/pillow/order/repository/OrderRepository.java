package com.pillow.pillow.order.repository;

import com.pillow.pillow.order.model.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findAll();

    @EntityGraph(attributePaths = {"orderItems"})
    List<Order> findAllWithItems();

}
