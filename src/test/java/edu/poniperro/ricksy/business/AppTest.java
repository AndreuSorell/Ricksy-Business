package edu.poniperro.ricksy.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
    @Test
    public void creditCard() {
        assertEquals( "4916119711304546",  abradolph.toString());
    }

    UfosPark ufo = new UfosPark();

    @Test
    public void addOvni() {
        ufo.add("dox");
        assertEquals( "flota={dox=null}", ufo.toString());
    }
}
