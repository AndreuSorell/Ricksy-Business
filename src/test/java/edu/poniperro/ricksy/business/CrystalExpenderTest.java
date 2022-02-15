package edu.poniperro.ricksy.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CrystalExpenderTest {
    private CrystalExpender packs = null;
    @Before
    public void setupCrystalExpender() {
        packs = new CrystalExpender(3, 50);
    }

    @Test
    public void constructorTest() {
        assertNotNull("Packs añadidos", packs);
        assertEquals(3, packs.stock());
    }

    @Test
    public void dispatchPackTest() {
        CreditCard abradolph = new CreditCard("Abradolf Lincler", "4916119711304546");
        packs.dispatch(abradolph);
        assertEquals(2950.0, abradolph.credit(), 0);
        assertEquals(2, packs.stock());

        CreditCard gearHead = new CreditCard("Gearhead", "8888888888888888");
        gearHead.pay(3000);
        packs.dispatch(gearHead);
        assertEquals(0.0, gearHead.credit(), 0);
        assertEquals(2, packs.stock());
    }
}
