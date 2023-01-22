package moneycalculator.persistance.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistance.ExchangeRateLoader;

public class ExchangeRateLoaderFromWebService implements ExchangeRateLoader {
    
    @Override
    public ExchangeRate exchangerateLoader(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
        } catch (IOException ex) {
            return null;
           // Logger.getLogger(ExchangeRateLoaderFromWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private double read(String codeFrom, String codeTo) throws MalformedURLException, IOException {
        String line = read(new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/"+codeFrom +"/" + codeTo+".json"));
        return Double.parseDouble(getStringRateFromJSONLine(line));
    }

    private String getStringRateFromJSONLine(String line) {
        String[] split = line.split(",");
        return split[1].substring(split[1].indexOf(":")+1,split[1].indexOf("}")-1);
    }

    private String read(URL url) throws IOException {
        InputStream inputStream = url.openStream();
        byte[] buffer = new byte[1024];
        int length = inputStream.read(buffer);
        return new String(buffer, 1, length);
    }
    
    
}
