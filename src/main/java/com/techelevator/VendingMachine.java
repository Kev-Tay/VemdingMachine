package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements Transactionable {

    private Map<Slot, StuffedAnimal> slotLocation = new HashMap<>();
    private BigDecimal balance;
    private BigDecimal insertedFunds = new BigDecimal(0);


    public VendingMachine(){
        this.balance = new BigDecimal(0);
    }
    public Map<Slot, StuffedAnimal> getSlotLocation() {
        return slotLocation;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setInsertedFunds(BigDecimal insertedFunds) {
        this.insertedFunds = insertedFunds;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void takeMoney(BigDecimal money) {
        insertedFunds = insertedFunds.add(money);
    }

    public BigDecimal getInsertedFunds() {
        return insertedFunds;
    }

    public void makeSale(BigDecimal itemPrice) {
        if (insertedFunds.compareTo(itemPrice) >= 0) {
            insertedFunds = insertedFunds.subtract(itemPrice);
            balance = balance.add(itemPrice);
        }
    }

    public String giveChange() {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        BigDecimal valueOfQuarter = BigDecimal.valueOf(0.25);
        BigDecimal valueOfDime = BigDecimal.valueOf(0.10);
        BigDecimal valueOfNickel = BigDecimal.valueOf(0.05);
        BigDecimal valueOfPenny = BigDecimal.valueOf(0.01);

        while(insertedFunds.compareTo(valueOfQuarter) >= 0) {
            quarters += 1;
            insertedFunds = insertedFunds.subtract(BigDecimal.valueOf(0.25));
        }
        while(insertedFunds.compareTo(valueOfDime) >= 0) {
            dimes += 1;
            insertedFunds = insertedFunds.subtract(BigDecimal.valueOf(0.10));
        }
        while(insertedFunds.compareTo(valueOfNickel) >= 0) {
            nickels += 1;
            insertedFunds = insertedFunds.subtract(BigDecimal.valueOf(0.05));
        }
        while(insertedFunds.compareTo(valueOfPenny) >= 0) {
            pennies += 1;
            insertedFunds = insertedFunds.subtract(BigDecimal.valueOf(0.01));
        }
        insertedFunds = insertedFunds.subtract(insertedFunds);
        return "You get " + quarters + " Quarter(s), " + dimes + " Dime(s), " + nickels + " Nickel(s), " + pennies + " Penny(s)";



    }
}
