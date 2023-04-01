package com.neosoft.currency.service;

import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CurrencyDTO;
import com.neosoft.currency.model.Cryptocurrency;
import com.neosoft.currency.model.Currency;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CurrencyService {

     ResponseEntity<BaseResponse> saveCurrency(CurrencyDTO currencyDTO);

     ResponseEntity<BaseResponse> findAll();

     ResponseEntity<BaseResponse> findById(UUID id);

     ResponseEntity<BaseResponse> deleteCurrency(UUID id);

     ResponseEntity<BaseResponse> updateCurrency(UUID id,Currency currency);
}
