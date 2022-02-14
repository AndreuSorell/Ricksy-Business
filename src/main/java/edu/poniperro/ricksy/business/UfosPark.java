package edu.poniperro.ricksy.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UfosPark implements GuestDispatcher{
    private double fee = 500;
    private final Map<String, String> flota = new HashMap<String, String>();

    public UfosPark() { }

    void add(String ovni) {
        flota.putIfAbsent(ovni, null);
    }
    
    @Override
    public void dispatch(CreditCard invitado) {
        /* 
        Recibe el objeto tarjeta de crédito del invitado/a
         * en el método dispatch(card)
         * y realiza un cargo a la tarjeta.
         * Si hay saldo suficiente se reserva un UberOvni
         * de los que estén libres.
         * El coste del ovni es de 500 EZIs.
        */
        if (invitado.pay(fee) && flota.containsValue(null)) {
            for (String key : flota.keySet()) {
                if (flota.get(key) == null) {
                    flota.replace(key, invitado.number());
                    break;
                }
            }
        }
        else {
            System.out.println("no hay saldo suficiente o no hay ovnis diponibles");
        }
    }

    String getUfoOf(String card) {
        for (String key : flota.keySet()) {
            if (flota.get(key) == card) {
                return key;
            }
        }
        return "No tiene ningun ovni asignado";
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
