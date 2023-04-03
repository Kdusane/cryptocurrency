package com.neosoft.currency.service;

import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CryptoCurrencyDTO;
import org.springframework.http.ResponseEntity;


import java.util.UUID;


public interface CryptoCurrencyService {
    ResponseEntity<BaseResponse> saveCryptoCurrency(CryptoCurrencyDTO cryptoCurrencyDTO) throws Exception;

    ResponseEntity<BaseResponse> findAllCryptoCurrency();

    ResponseEntity<BaseResponse> findByCryptoCurrencyId(UUID id) throws Exception;

    ResponseEntity<BaseResponse> deleteCryptoCurrency(UUID id) throws Exception;

    ResponseEntity<BaseResponse> updateByCryptoCurrency(UUID id, CryptoCurrencyDTO cryptoCurrencyDTO) throws Exception;
}
