package com.simulation.swimmingpool_ticketing.repository;

import com.simulation.swimmingpool_ticketing.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
