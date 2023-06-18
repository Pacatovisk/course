package com.pacatovisk.course.repositories;

import com.pacatovisk.course.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
