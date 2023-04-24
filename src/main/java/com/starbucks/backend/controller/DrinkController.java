package com.starbucks.backend.controller;

import com.starbucks.backend.model.Drink;
import com.starbucks.backend.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrinkController {

    @Autowired
    private DrinkRepository drinkRepository;

    @PostMapping("/drink")
    Drink newDrink(@RequestBody Drink newDrink) {
        return drinkRepository.save(newDrink);
    }

    @GetMapping("/drinks")
    List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }
}
