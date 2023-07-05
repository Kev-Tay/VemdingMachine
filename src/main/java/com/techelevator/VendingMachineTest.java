package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTest {

    @Test
    public void changes_balance_for_sale() {
        //Arrange
        VendingMachine test = new VendingMachine();
        test.setInsertedFunds(BigDecimal.valueOf(10));
        BigDecimal balance = new BigDecimal(10);
        test.setBalance(balance);
        BigDecimal itemPrice = new BigDecimal(5);

        //Act
        test.makeSale(itemPrice);
        BigDecimal actual = test.getBalance();
        BigDecimal expected = new BigDecimal(15);

        //Assert
        Assert.assertEquals("makeSale does not correctly add to balance", expected, actual);
    }

    @Test
    public void does_take_money(){
        //Arrange
        VendingMachine test = new VendingMachine();
        test.setInsertedFunds(BigDecimal.valueOf(10));
        BigDecimal insertedFunds = new BigDecimal(10);

        //Act
        test.takeMoney(insertedFunds);
        BigDecimal actual = test.getInsertedFunds();
        BigDecimal expected = new BigDecimal(20);

        //Assert
        Assert.assertEquals("insertedFunds does not correctly add to balance", expected, actual);
    }


    //TODO make change test




}
