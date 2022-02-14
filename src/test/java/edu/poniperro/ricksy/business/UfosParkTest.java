package edu.poniperro.ricksy.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class UfosParkTest {
    UfosPark ufos = null;
    String[] ovnis = { "unx", "dox", "trex" };

    @Before
    public void setupUfosPark() {
        ufos = new UfosPark();
        assertNotNull("Parque de UFOS creados", ufos);
        for (String ovni : ovnis) {
			ufos.add(ovni);
        }
    }
    
    @Test
    public void addOvniTest() {
        assertEquals( "flota={trex=null, dox=null, unx=null}", ufos.toString());
    }
    
    //comprobamos que se ha reducido el credito de la tarjeta y se le ha assignado una nave
    @Test
    public void dispatchTest() {
        CreditCard abradolph = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(abradolph);
        assertEquals("trex", ufos.getUfoOf(abradolph.number()));
        assertEquals(2500.0, abradolph.credit(), 0);
        //comprobamos que si Abradolf quiere mas ovnis no puede porque ya tiene uno
        ufos.dispatch(abradolph);
        assertEquals("trex", ufos.getUfoOf(abradolph.number()));
        assertEquals(2500.0, abradolph.credit(), 0);

    }

}
