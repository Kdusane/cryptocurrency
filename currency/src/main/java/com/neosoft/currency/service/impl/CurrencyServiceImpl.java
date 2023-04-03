package com.neosoft.currency.service.impl;

import com.neosoft.currency.constants.ConstantUtils;
import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CurrencyDTO;
import com.neosoft.currency.exception.NotFoundException;
import com.neosoft.currency.helper.CurrencyHelper;
import com.neosoft.currency.model.Currency;
import com.neosoft.currency.repository.CurrencyRepo;
import com.neosoft.currency.service.CurrencyService;
import liquibase.util.ObjectUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepo currencyRepo;


    public ResponseEntity<BaseResponse> saveCurrency(CurrencyDTO currencyDTO) throws Exception {
       Currency currency = CurrencyHelper.currencyBuildEntity(currencyDTO);
       Currency saveCurrency= currencyRepo.save(currency);
       if(saveCurrency==null)
                throw new Exception(ConstantUtils.SOMETHING_WENT_WRONG);
           BaseResponse baseResponse = BaseResponse.builder()
                   .data(saveCurrency)
                   .message(ConstantUtils.SUCCESFULLY_ADDED)
                   .statusCode(HttpStatus.CREATED.value())
                   .build();
           return ResponseEntity.ok(baseResponse);
    }


    @Override
    public ResponseEntity<BaseResponse> findAllCurrency() {
        List<Currency> currencyList=currencyRepo.findAll();
        if(ObjectUtils.isEmpty(currencyList))
        {
            BaseResponse baseResponse= BaseResponse.builder()
                    .data(new ArrayList<>())
                    .message(ConstantUtils.NO_CONTENT)
                    .statusCode(HttpStatus.NO_CONTENT.value()).build();
            return ResponseEntity.ok(baseResponse);
        }
        BaseResponse baseResponse=BaseResponse.builder()
                .data(currencyList)
                .message(ConstantUtils.SUCCESSFULLY_FETCHED)
                .statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.ok(baseResponse);

    }

    @Override
    public ResponseEntity<BaseResponse> findByCurrencyId(UUID id) throws Exception {
        Optional<Currency> currencyOptional=currencyRepo.findById(id);
        if(!currencyOptional.isPresent())
            throw new NotFoundException(ConstantUtils.CURRENCY_NOT_FOUND);
        BaseResponse baseResponse=BaseResponse.builder()
                .data(currencyOptional.get())
                .message(ConstantUtils.CURRENCY_FOUND)
                .statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.ok(baseResponse);

    }

    @Override
    public ResponseEntity<BaseResponse> deleteCurrency(UUID id) throws Exception {
        Optional<Currency> currencyOptional =currencyRepo.findById(id);
        if(!currencyOptional.isPresent())
            throw new NotFoundException(ConstantUtils.CURRENCY_NOT_FOUND);
        currencyRepo.delete(currencyOptional.get());
        BaseResponse baseResponse=BaseResponse.builder()
                .data(null)
                .message(ConstantUtils.SUCCESFULLY_DELETED)
                .statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.ok(baseResponse);

    }

    @Override
    public ResponseEntity<BaseResponse> updateCurrency(UUID id, CurrencyDTO currencyDTO) throws Exception {
        Optional<Currency> currencyOptional=currencyRepo.findById(id);
        if(!currencyOptional.isPresent())
            throw new NotFoundException(ConstantUtils.CURRENCY_NOT_FOUND);
        currencyOptional.get().setName(currencyDTO.getName());
        currencyOptional.get().setSymbol(currencyDTO.getSymbol());
        currencyOptional.get().setCountry(currencyDTO.getCountry());
        currencyOptional.get().setQuotation(currencyDTO.getQuotation());
        currencyRepo.save(currencyOptional.get());
        BaseResponse baseResponse=BaseResponse.builder()
                .data(currencyOptional.get())
                .message(ConstantUtils.SUCCESSFULLY_UPDATED)
                .statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.ok(baseResponse);
    }
}
