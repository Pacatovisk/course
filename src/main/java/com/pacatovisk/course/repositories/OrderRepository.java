package com.pacatovisk.course.repositories;

import com.pacatovisk.course.entities.Order;
import com.pacatovisk.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
