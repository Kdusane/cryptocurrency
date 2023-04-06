package com.neosoft.currency.helper;

import com.neosoft.currency.domain.requestDTO.CurrencyDTO;
import com.neosoft.currency.model.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CurrencyHelper {

    private CurrencyHelper(){}

    public  static Currency currencyBuildEntity(CurrencyDTO currencyDTO){

        Currency currency = Currency.builder()
                .country(currencyDTO.getCountry())
                .build();
        currency.setQuotation(currencyDTO.getQuotation());
        currency.setSymbol(currencyDTO.getSymbol());
        currency.setId(UUID.randomUUID());
        currency.setName(currencyDTO.getName());
//        List<Cryptocurrency> cryptocurrencyList=new ArrayList<>();
//        for (CryptoCurrencyDTO cryptoCurrencyDTO:currencyDTO.getCryptoCurrencyDTOS()){
//            Cryptocurrency cryptocurrency=CryptoCurrencyHelper.cryptoCurrencyBuildEntity(cryptoCurrencyDTO);
//            cryptocurrencyList.add(cryptocurrency);
//        }
//        currency.setCryptocurrency(cryptocurrencyList);
        return currency;
    }


}
