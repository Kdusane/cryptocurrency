package com.neosoft.currency.controller;

import com.neosoft.currency.model.Cryptocurrency;
import com.neosoft.currency.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cryptoCurrency")
public class CryptoCurrencyController {
    @Autowired
    CryptoCurrencyService cryptoCurrencyService;

    @PostMapping("/save")
    public Cryptocurrency saveCryptoCurrency(@RequestBody Cryptocurrency cryptocurrency)
    {
        return cryptoCurrencyService.saveCryptoCurrency(cryptocurrency);
    }

    @GetMapping("/findAll")
    public List<Cryptocurrency> findAllCryptoCurrency()
    {
        return cryptoCurrencyService.findAll();
    }

    @GetMapping("/findById")
    public Optional<Cryptocurrency> findById(@PathVariable UUID id)
    {
        return cryptoCurrencyService.findById(id);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable UUID id)
    {
        return cryptoCurrencyService.deleteCryptoCurrency(id);
    }
}
