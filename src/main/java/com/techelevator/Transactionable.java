package com.techelevator;

import java.math.BigDecimal;

public interface Transactionable {

    //TODO Maybe need to keep track of time/date here
    public void takeMoney(BigDecimal money);

    //TODO make String message here or change as other type?
    public String giveChange();
}
