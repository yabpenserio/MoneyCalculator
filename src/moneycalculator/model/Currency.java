package moneycalculator.model;

public class Currency {
    private final String code;
    private final String name;
    private final String symbol;
    
    

    public Currency(String code, String name, String symbol) {
        this.symbol = symbol;
        this.name = name;
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    @Override
    public String toString() {
        return code + " - " + name;
    }
    
}
