package com.starbucks.backend.controller;

import com.starbucks.backend.exception.MenuItemNotFoundException;
import com.starbucks.backend.model.Drink;
import com.starbucks.backend.repositories.DrinkRepository;
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

    @PutMapping("/drink/{id}")
    Drink updateDrinkById(@RequestBody Drink newDrink, @PathVariable Long id) {
        return drinkRepository.findById(id)
                .map(drink-> {
                    drink.setName(newDrink.getName());
                    drink.setCategory(newDrink.getCategory());
                    drink.setSubcategory(newDrink.getSubcategory());
                    drink.setPrice(newDrink.getPrice());
                    drink.setImageUrl(newDrink.getImageUrl());
                    return drinkRepository.save(drink);
                }).orElseThrow(()-> new MenuItemNotFoundException(id));
    }

    @DeleteMapping("/drink/{id}")
    String deleteDrinkById(@PathVariable Long id) {
        if (!drinkRepository.existsById(id)) {
            throw new MenuItemNotFoundException(id);
        }

        drinkRepository.deleteById(id);
        return "Menu item id: " + id + " has been successfully deleted";
    }
}
