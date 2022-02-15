package edu.poniperro.ricksy.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UfosParkTest {
    UfosPark ufos = null;
    String[] ovnis = { "unx", "dox", "trex" };

    @Before
    public void setupUfosPark() {
        ufos = new UfosPark();
        assertNotNull(ufos);
        for (String ovni : ovnis) {
			ufos.add(ovni);
        }
    }
    
    @Test
    public void addOvniTest() {
        assertEquals( "[trex, dox, unx]", ufos.toString());
        assertEquals(ovnis.length, ufos.cardNumbers().size());
    }

    @Test
    public void dispatchTest() {
        //comprobamos que se ha reducido el credito de la tarjeta y se le ha assignado una nave
        CreditCard abradolph = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(abradolph);
        assertEquals("trex", ufos.getUfoOf(abradolph.number()));
        assertEquals(2500.0, abradolph.credit(), 0);

        //comprobamos que si Abradolf quiere mas ovnis no puede porque ya tiene uno
        ufos.dispatch(abradolph);
        assertEquals("trex", ufos.getUfoOf(abradolph.number()));
        assertEquals(2500.0, abradolph.credit(), 0);
        
        //comprobamos que sin blanca no hay ovni
        CreditCard gearHead = new CreditCard("Gearhead", "8888888888888888");
        gearHead.pay(3000); // le vacían la cartera
        ufos.dispatch(gearHead);
        assertEquals("No tiene ningun ovni asignado", ufos.getUfoOf(gearHead.number()));
        assertEquals(0.0, gearHead.credit(), 0);
        assertFalse(ufos.containsCard(gearHead.number()));
    }
}
