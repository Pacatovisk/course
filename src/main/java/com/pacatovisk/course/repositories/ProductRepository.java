package com.pacatovisk.course.repositories;

import com.pacatovisk.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
