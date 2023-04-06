package com.neosoft.currency.helper;

import com.neosoft.currency.domain.requestDTO.CryptoCurrencyDTO;

import com.neosoft.currency.model.Cryptocurrency;


import java.util.UUID;

public class CryptoCurrencyHelper {

    private CryptoCurrencyHelper(){}

    public  static Cryptocurrency cryptoCurrencyBuildEntity(CryptoCurrencyDTO cryptoCurrencyDTO){

        Cryptocurrency cryptocurrency = Cryptocurrency.builder().build();
        cryptocurrency.setId(UUID.randomUUID());
        cryptocurrency.setSymbol(cryptoCurrencyDTO.getSymbol());
        cryptocurrency.setName(cryptoCurrencyDTO.getName());
        cryptocurrency.setQuotation(cryptoCurrencyDTO.getQuotation());
        return cryptocurrency;}

}
