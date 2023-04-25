package com.starbucks.backend.controller;

import com.starbucks.backend.exception.MenuItemNotFoundException;
import com.starbucks.backend.model.Drink;
import com.starbucks.backend.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
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

    @GetMapping("/drink/{id}")
    Drink getDrinkById(@PathVariable Long id) {
        return drinkRepository.findById(id)
                .orElseThrow(()->new MenuItemNotFoundException(id));
    }
}
