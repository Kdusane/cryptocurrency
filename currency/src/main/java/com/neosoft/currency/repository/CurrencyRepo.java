package com.neosoft.currency.repository;

import com.neosoft.currency.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, UUID> {
    Currency findByName(String name);
}
