package com.techelevator;

import java.math.BigDecimal;

public class Cat extends StuffedAnimal{
    private String message;

    public Cat(String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
        this.message = "Meow, Meow, Meow!";
    }

    public String getMessage() {
        return message;
    }
}
