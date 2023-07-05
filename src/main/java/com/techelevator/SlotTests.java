package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class SlotTests {
@Test
    public void dispense_aninaml_inventory_changes(){
        VendingMachine slot = new VendingMachine();
        Pony fluffy = new Pony("Pony", BigDecimal.valueOf(2));
        Slot test = new Slot("A1", fluffy, slot);
        test.dispenseAnimal();
        Assert.assertEquals(test.getInventory(), 4);
    }
    @Test
    public void getSlotInfo_returns_string_info(){
        VendingMachine slot = new VendingMachine();
        Pony fluffy = new Pony("Pony", BigDecimal.valueOf(2));
        Slot test = new Slot("A1", fluffy, slot);
        String acutal = test.getSlotInfo();
        String expected = "A1 Pony 2";
        Assert.assertEquals("getSlotInfo returned wrong infomation.", expected, acutal);
    }

    @Test
    public void getSlotInfo_returns_out_of_stock(){
        VendingMachine slot = new VendingMachine();
        Pony fluffy = new Pony("Pony", BigDecimal.valueOf(2));
        Slot test = new Slot("A1", fluffy, slot);
        test.setInventory(0);
        String acutal = test.getSlotInfo();
        String expected = "A1 out of stock!";
        Assert.assertEquals("getSlotInfo returned wrong infomation.", expected, acutal);

    }
}
