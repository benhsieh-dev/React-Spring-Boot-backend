package com.starbucks.backend.exception;

public class MenuItemNotFoundException extends RuntimeException {

    public MenuItemNotFoundException(Long id) {
        super("Could not find menu item with id: " + id);
    }
}
