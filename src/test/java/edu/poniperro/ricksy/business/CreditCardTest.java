package edu.poniperro.ricksy.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreditCardTest {
    CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
    @Test
    public void creditCardTest() {
        assertEquals( "4916119711304546 EZI",  abradolph.toString());
    }
}
