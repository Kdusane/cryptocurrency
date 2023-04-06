package com.neosoft.currency.service.impl;

import com.neosoft.currency.constants.ConstantUtils;
import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CryptoCurrencyDTO;
import com.neosoft.currency.exception.AlreadyPresentException;
import com.neosoft.currency.exception.NotFoundException;
import com.neosoft.currency.helper.CryptoCurrencyHelper;
import com.neosoft.currency.model.Cryptocurrency;
import com.neosoft.currency.repository.CryptoCurrencyRepo;
import com.neosoft.currency.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CryptoCurrencyImpl implements CryptoCurrencyService {
    @Autowired
    CryptoCurrencyRepo cryptoCurrencyRepo;

    @Override
    public ResponseEntity<BaseResponse> saveCryptoCurrency(CryptoCurrencyDTO cryptoCurrencyDTO) {
        Cryptocurrency cryptocurrencyexist = cryptoCurrencyRepo.findByName(cryptoCurrencyDTO.getName());
        if (cryptocurrencyexist != null)
            throw new AlreadyPresentException(ConstantUtils.CRYPTOCURRENCY_ALREADY_PRESENT);
        Cryptocurrency cryptocurrency = CryptoCurrencyHelper.cryptoCurrencyBuildEntity(cryptoCurrencyDTO);
        Cryptocurrency saveCryptoCurrency = cryptoCurrencyRepo.save(cryptocurrency);
        BaseResponse baseResponse = BaseResponse.builder().data(saveCryptoCurrency).message(ConstantUtils.SUCCESFULLY_ADDED).statusCode(HttpStatus.CREATED.value()).build();
        return ResponseEntity.ok(baseResponse);
    }


    @Override
    public ResponseEntity<BaseResponse> findAllCryptoCurrency() {
        List<Cryptocurrency> cryptoCurrencyList = cryptoCurrencyRepo.findAll();
        BaseResponse baseResponse = BaseResponse.builder().data(cryptoCurrencyList).message(ConstantUtils.SUCCESSFULLY_FETCHED).statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> findByCryptoCurrencyId(UUID id) {
        Optional<Cryptocurrency> cryptocurrencyOptional = cryptoCurrencyRepo.findById(id);
        if (cryptocurrencyOptional.isEmpty()) throw new NotFoundException(ConstantUtils.CRYPTOCURRENCY_NOT_FOUND);
        BaseResponse baseResponse = BaseResponse.builder().data(cryptocurrencyOptional.get()).message(ConstantUtils.CRYPTOCURRENCY_FOUND).statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.ok(baseResponse);

    }

    @Override
    public ResponseEntity<BaseResponse> deleteCryptoCurrency(UUID id) {
        Optional<Cryptocurrency> cryptocurrencyOptional = cryptoCurrencyRepo.findById(id);
        if (cryptocurrencyOptional.isEmpty()) throw new NotFoundException(ConstantUtils.CRYPTOCURRENCY_NOT_FOUND);
        cryptoCurrencyRepo.delete(cryptocurrencyOptional.get());
        BaseResponse baseResponse = BaseResponse.builder().data(null).message(ConstantUtils.SUCCESFULLY_DELETED).statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> updateByCryptoCurrency(UUID id, CryptoCurrencyDTO cryptoCurrencyDTO) {
        Optional<Cryptocurrency> cryptocurrencyOptional = cryptoCurrencyRepo.findById(id);
        if (cryptocurrencyOptional.isEmpty()) throw new NotFoundException(ConstantUtils.CRYPTOCURRENCY_NOT_FOUND);
        if (cryptoCurrencyDTO.getName() != null) cryptocurrencyOptional.get().setName(cryptoCurrencyDTO.getName());
        if (cryptoCurrencyDTO.getSymbol() != null)
            cryptocurrencyOptional.get().setSymbol(cryptoCurrencyDTO.getSymbol());
        if (cryptoCurrencyDTO.getQuotation() != null)
            cryptocurrencyOptional.get().setQuotation(cryptoCurrencyDTO.getQuotation());
        cryptoCurrencyRepo.save(cryptocurrencyOptional.get());
        BaseResponse baseResponse = BaseResponse.builder().data(cryptocurrencyOptional.get()).message(ConstantUtils.SUCCESSFULLY_UPDATED).statusCode(HttpStatus.OK.value()).build();
        return ResponseEntity.ok(baseResponse);
    }
}
