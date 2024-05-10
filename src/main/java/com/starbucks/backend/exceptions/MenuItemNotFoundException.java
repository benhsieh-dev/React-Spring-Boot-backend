package com.starbucks.backend.exceptions;

public class MenuItemNotFoundException extends RuntimeException {

    public MenuItemNotFoundException(Long id) {
        super("Could not find menu item with id: " + id);
    }
}
