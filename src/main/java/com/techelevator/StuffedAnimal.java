package com.techelevator;

import java.math.BigDecimal;

abstract class StuffedAnimal {
    private String itemName;
    private BigDecimal itemPrice;
    private String itemType;
    private String message;

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public String getMessage(){
        return message;
    }

    public String getItemName() {
        return itemName;
    }

    public StuffedAnimal(String itemName, BigDecimal itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
}
