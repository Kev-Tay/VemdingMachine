package com.techelevator;

import java.math.BigDecimal;

public class Penguin extends StuffedAnimal{

    private String message;

    public Penguin(String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
        this.message = "Squack, Squack, Whee!";
    }

    public String getMessage() {
        return message;
    }
}
