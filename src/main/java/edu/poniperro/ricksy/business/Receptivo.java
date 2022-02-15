package edu.poniperro.ricksy.business;

import java.util.ArrayList;
import java.util.List;

public class Receptivo {
    private List<GuestDispatcher> observers = new ArrayList<GuestDispatcher>();

    public Receptivo() { }

    void registra(GuestDispatcher observer) {
        this.observers.add(observer);
    }

    void dispatch(CreditCard invitado) {
       for (GuestDispatcher observer: observers) {
           observer.dispatch(invitado);
       }
    }


}
