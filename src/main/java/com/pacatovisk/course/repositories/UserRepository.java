package com.pacatovisk.course.repositories;

import com.pacatovisk.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
