package com.starbucks.backend.repositories;

import com.starbucks.backend.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
