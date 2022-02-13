package edu.poniperro.ricksy.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher{
    private double fee;
    private Map<String, String> flota = new HashMap<String, String>();

    public UfosPark() { }

    void add(String ovni) {
        flota.putIfAbsent(ovni, null);
    }

    @Override
    public void dispatch(CreditCard card) {
        /* 
        Recibe el objeto tarjeta de crédito del invitado/a
         * en el método dispatch(card)
         * y realiza un cargo a la tarjeta.
         * Si hay saldo suficiente se reserva un UberOvni
         * de los que estén libres.
         * El coste del ovni es de 500 EZIs.
        */
        card.pay(500);
    }

    String getUfoOf(String card) {
        //de momento
        return null;
    }

    @Override
    public String toString() {
        return "flota=" + flota;
    }

    boolean containsCard(String card) {
        //de momento
        return true;
    }

    Collection<String> cardNumbers() {
        return null;
        // de momento
    }

}
