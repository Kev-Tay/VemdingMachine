package com.techelevator;

import java.math.BigDecimal;

public class Duck extends StuffedAnimal {
    private String message;

    public Duck(String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
        this.message = "Quack, Quack, Splash!";
    }

    public String getMessage() {
        return message;
    }
}
