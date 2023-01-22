package moneycalculator.persistance.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import moneycalculator.model.Currency;
import moneycalculator.persistance.CurrencyLoader;

/**
 *
 * @author yabpe
 */
public class CurrencyLoaderFromFile implements CurrencyLoader{
    private final String fileName;

    public CurrencyLoaderFromFile(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public List<Currency> loadCurrencies(){
        List<Currency> list = new ArrayList<>();
        
        try{
        BufferedReader reader = new BufferedReader(new FileReader
                                (new File(this.fileName)));
        IteratorReader iteratorReader = new IteratorReader(reader);
        for (String line: iteratorReader){
            list.add(currencyOf(line));
        }
        reader.close();
        }catch(FileNotFoundException exception){
            System.out.println("CurrencyLoaderFromFile  :: loadCurrencies, FileNotFound" 
            + exception.getMessage());
        }catch(IOException exception){
            System.out.println("CurrencyLoaderFromFile  :: loadCurrencies, IO"
            +exception.getMessage());
        }
        return list;
    }
    private Currency currencyOf(String line){
        String[] split = line.split(",");
        
        return new Currency(split[0],split[1],split[2]);
        
    }
}
