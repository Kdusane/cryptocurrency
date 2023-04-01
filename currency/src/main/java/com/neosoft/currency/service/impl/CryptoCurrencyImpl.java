package com.neosoft.currency.service.impl;

import com.neosoft.currency.model.Cryptocurrency;
import com.neosoft.currency.repository.CryptoCurrencyRepo;
import com.neosoft.currency.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CryptoCurrencyImpl implements CryptoCurrencyService {
    @Autowired
    CryptoCurrencyRepo cryptoCurrencyRepo;

    @Override
    public Cryptocurrency saveCryptoCurrency(Cryptocurrency cryptocurrency) {
        return cryptoCurrencyRepo.save(cryptocurrency);
    }

    @Override
    public List<Cryptocurrency> findAll() {
        return cryptoCurrencyRepo.findAll();
    }

    @Override
    public Optional<Cryptocurrency> findById(UUID id) {
        return cryptoCurrencyRepo.findById(id);
    }

    @Override
    public String deleteCryptoCurrency(UUID id) {
        Cryptocurrency cryptocurrency=cryptoCurrencyRepo.findById(id).get();
        cryptoCurrencyRepo.delete(cryptocurrency);
        return "deleted";
    }
}
