package edu.poniperro.ricksy.business;

public class CrystalExpender implements GuestDispatcher {

    private int stock = 0;
    private double itemCost = 0d;

    

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(CreditCard invitado) {
        if (this.stock > 0 && invitado.pay(this.itemCost)) {
            this.stock -= 1;
        }
    }

    @Override
    public String toString() {
        return "stock: " + this.stock + "\ncost: " + this.itemCost;
    }

    int stock() {
        return this.stock;
    }
}
