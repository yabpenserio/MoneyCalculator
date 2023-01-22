
package moneycalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moneycalculator.model.Money;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Currency;
import moneycalculator.persistance.ExchangeRateLoader;
import moneycalculator.view.swing.*;

public class MCController {
    
    MCViewSwing displaySwing;
    ExchangeRateLoader exchangeRateLoader;
    
    public MCController(ExchangeRateLoader exchangeRateLoader, MCViewSwing view) {
        this.displaySwing = view;
        this.displaySwing.addConvertListener(new ConvertListener());
        
        this.exchangeRateLoader = exchangeRateLoader;
          
    }

    private class ConvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Money moneyFrom = displaySwing.getMoneyFrom();
            Currency currencyTo = displaySwing.getCurrencyTo();
            
            if (moneyFrom == null) return;
            
            ExchangeRate exchangeRate = exchangeRateLoader.exchangerateLoader(moneyFrom.getCurrency(), currencyTo);
            displaySwing.refreshMoney(new Money(exchangeRate.convert(moneyFrom.getAmount()), currencyTo));
        }
    }
}

    

