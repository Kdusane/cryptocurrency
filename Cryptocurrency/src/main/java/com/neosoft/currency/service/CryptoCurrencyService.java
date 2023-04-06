package com.neosoft.currency.service;

import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CryptoCurrencyDTO;
import org.springframework.http.ResponseEntity;


import java.util.UUID;


public interface CryptoCurrencyService {
    ResponseEntity<BaseResponse> saveCryptoCurrency(CryptoCurrencyDTO cryptoCurrencyDTO) ;

    ResponseEntity<BaseResponse> findAllCryptoCurrency();

    ResponseEntity<BaseResponse> findByCryptoCurrencyId(UUID id);

    ResponseEntity<BaseResponse> deleteCryptoCurrency(UUID id) ;

    ResponseEntity<BaseResponse> updateByCryptoCurrency(UUID id, CryptoCurrencyDTO cryptoCurrencyDTO) ;
}
