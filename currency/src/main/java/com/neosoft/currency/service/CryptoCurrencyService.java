package com.neosoft.currency.service;

import com.neosoft.currency.model.Cryptocurrency;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CryptoCurrencyService {
    Cryptocurrency saveCryptoCurrency(Cryptocurrency cryptocurrency);

    List<Cryptocurrency> findAll();

    Optional<Cryptocurrency> findById(UUID id);

    String deleteCryptoCurrency(UUID id);
}
