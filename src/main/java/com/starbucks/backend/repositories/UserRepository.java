package com.starbucks.backend.repositories;

import com.starbucks.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository extends JpaRepository<qUser, Long> {
}
