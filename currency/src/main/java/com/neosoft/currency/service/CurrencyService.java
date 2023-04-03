package com.neosoft.currency.service;


import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CurrencyDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;


public interface CurrencyService {

     ResponseEntity<BaseResponse> saveCurrency(CurrencyDTO currencyDTO) throws Exception;

     ResponseEntity<BaseResponse> findAllCurrency();

     ResponseEntity<BaseResponse> findByCurrencyId(UUID id) throws Exception;

     ResponseEntity<BaseResponse> deleteCurrency(UUID id) throws Exception;

     ResponseEntity<BaseResponse> updateCurrency(UUID id, CurrencyDTO currencyDTO) throws Exception;
}
