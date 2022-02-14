package edu.poniperro.ricksy.business;

import javax.swing.text.html.HTMLDocument.RunElement;

public class CreditCard {
    private final String owner;
    private final String number;
    private double credit = 3000;
    private final String SYMBOL = "EZI";

    CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    boolean pay(double precio) {
        if (precio <= credit) {
            this.credit -= precio;
            return true;
        }
        else {
            return false;
        }
    }

    String number() {
        return this.number;
    }
    String cardOwner() {
        return this.owner;
    }

    double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        return  number();
    }

    
}
