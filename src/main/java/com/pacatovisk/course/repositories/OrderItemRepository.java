package com.pacatovisk.course.repositories;

import com.pacatovisk.course.entities.OrderItem;
import com.pacatovisk.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
