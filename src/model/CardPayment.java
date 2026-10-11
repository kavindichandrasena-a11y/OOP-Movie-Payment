package model;

public class CardPayment extends Payment {

    private String method;

    public CardPayment(double amount, String method) {
        super(amount);
        this.method = method;
    }

    public String toFileString() {
        return method + "," + amount;
    }
}

