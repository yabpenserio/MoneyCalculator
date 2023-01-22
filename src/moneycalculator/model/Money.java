package moneycalculator.model;

public class Money {
    private double amount;
    private Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }
    public Currency getCurrency(){
        return currency;
    }
    public void setAmount(double am) {
        this.amount = am;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
