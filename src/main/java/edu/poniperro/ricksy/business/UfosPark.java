package edu.poniperro.ricksy.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher{
    private double fee = 500;
    private final Map<String, String> flota = new HashMap<String, String>();

    public UfosPark() { }

    void add(String ovni) {
        flota.putIfAbsent(ovni, null);
    }
    
    @Override
    public void dispatch(CreditCard invitado) {
        if (!flota.containsValue(invitado.number()) && flota.containsValue(null) && invitado.pay(fee))  {  
            for (String key : flota.keySet()) {
                if (flota.get(key) == null) {
                    flota.replace(key, invitado.number());
                    break;
                }
            }
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
        return this.flota.keySet().toString();
    }

    boolean containsCard(String card) {
        return this.flota.containsValue(card);
    }

    Collection<String> cardNumbers() {
        return this.flota.values();
    }

}
