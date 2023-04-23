package com.starbucks.backend.controller;

import com.starbucks.backend.model.Drink;
import com.starbucks.backend.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrinkController {

    @Autowired
    private DrinkRepository drinkRepository;

    @PostMapping("/drink")
    Drink newDrink(@RequestBody Drink newDrink) {
        return drinkRepository.save(newDrink);
    }
}
