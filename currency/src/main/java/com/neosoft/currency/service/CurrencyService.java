package com.neosoft.currency.service;


import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CurrencyDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;


public interface CurrencyService {

     ResponseEntity<BaseResponse> saveCurrency(CurrencyDTO currencyDTO) ;

     ResponseEntity<BaseResponse> findAllCurrency();

     ResponseEntity<BaseResponse> findByCurrencyId(UUID id);

     ResponseEntity<BaseResponse> deleteCurrency(UUID id) ;

     ResponseEntity<BaseResponse> updateCurrency(UUID id, CurrencyDTO currencyDTO);
}
