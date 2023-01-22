package moneycalculator.model;

import moneycalculator.model.Currency;

public class ExchangeRate {
    private final double ratio;
    private final Currency To;
    private final Currency From;

    public ExchangeRate(Currency From,Currency To,double ratio) {
        this.ratio = ratio;
        this.To = To;
        this.From = From;
    }
    public double convert(double v) {
        return Math.round((v*ratio)*100.0)/100.0;
    }
    public double getRatio() {
        return ratio;
    }

    public Currency getTo() {
        return To;
    }

    public Currency getFrom() {
        return From;
    }
    
    
}
