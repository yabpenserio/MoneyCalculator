package moneycalculator;

import java.util.List;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.persistance.file.CurrencyLoaderFromFile;
import moneycalculator.persistance.rest.ExchangeRateLoaderFromWebService;
import moneycalculator.view.swing.MoneyCalculatorGUISwing;
import moneycalculator.view.swing.MCViewSwing;

public class MoneyCalculator {

    public static void main(String[] args) {
        //model
        CurrencyLoaderFromFile currencyLoaderFromFile = new CurrencyLoaderFromFile ("currencies");
        List<Currency> currencies = currencyLoaderFromFile.loadCurrencies();
        ExchangeRateLoaderFromWebService exchangeRateLoaderFromWebService = new ExchangeRateLoaderFromWebService();
        
        //View
        //DialogSwing dialogSwing = new DialogSwing();
        //Control
        //new MoneyCalculatorGUISwing(dialogSwing, "Display Money Calculator...");

        MCViewSwing view = new MCViewSwing(currencies);
        MCController controller = new MCController(exchangeRateLoaderFromWebService, view);
        
        
        
        /*for (Currency currency: list){
            System.out.println(currency.getCode()+" - "+ currency.getName()+" - "+
                    currency.getSymbol());
            
        }
        for (Currency currencyFrom: list){
            for(Currency currencyTO: list){
                if(!currencyFrom.getCode().equals(currencyTo.getCode())){
                    ExchangeRate exchangeRate =;
                }
            }
        }*/
    }
    
}
