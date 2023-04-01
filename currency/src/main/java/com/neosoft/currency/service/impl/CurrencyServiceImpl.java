package com.neosoft.currency.service.impl;

import com.neosoft.currency.constants.ConstantsUtils;
import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CurrencyDTO;
import com.neosoft.currency.helper.CurrencyHelper;
import com.neosoft.currency.model.Currency;
import com.neosoft.currency.repository.CurrencyRepo;
import com.neosoft.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepo currencyRepo;


    public ResponseEntity<BaseResponse> saveCurrency(CurrencyDTO currencyDTO) {
       Currency currency = CurrencyHelper.currencyBuildEntity(currencyDTO);
       Currency saveCurrency= currencyRepo.save(currency);
       if(saveCurrency==null){

       }
           BaseResponse baseResponse = BaseResponse.builder()
                   .data(saveCurrency)
                   .message(ConstantsUtils.SUCCESFULLY_ADDED)
                   .statusCode(HttpStatus.OK.value())
                   .build();
           return ResponseEntity.ok(baseResponse);
    }


    @Override
    public List<Currency> findAll() {
        return currencyRepo.findAll();
    }

    @Override
    public Currency findById(UUID id) {
        return currencyRepo.findById(id).get();
    }

    @Override
    public String deleteCurrency(UUID id) {
        Currency currency =currencyRepo.findById(id).get();
        currencyRepo.delete(currency);
        return "deleted";
    }

    @Override
    public Currency updateCurrency(UUID id, Currency currency) {
        Currency currency1=currencyRepo.findById(id).get();
        currency1.setName(currency.getName());
        currency1.setSymbol(currency.getSymbol());
        currency1.setCountry(currency.getCountry());
        currency1.setQuotation(currency1.getQuotation());
        return currency1;
    }
}
