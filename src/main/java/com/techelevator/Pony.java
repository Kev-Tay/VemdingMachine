package com.techelevator;

import java.math.BigDecimal;

public class Pony extends StuffedAnimal{
    private String message;

    public Pony(String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
        this.message = "Neigh, Neigh, Yay!";
    }

    public String getMessage() {
        return message;
    }
}
