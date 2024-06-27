package com.simulation.swimmingpool_ticketing.repository;

import com.simulation.swimmingpool_ticketing.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
