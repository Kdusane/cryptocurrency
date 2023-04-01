package com.neosoft.currency.controller;

import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CurrencyDTO;
import com.neosoft.currency.model.Currency;
import com.neosoft.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @PostMapping()
    public ResponseEntity<BaseResponse> saveCurrency(@RequestBody CurrencyDTO currencyDTO)
    {
       return currencyService.saveCurrency(currencyDTO);
    }

    @GetMapping()
    public List<Currency> findAllCurrency()
    {
        return currencyService.findAll();
    }

    @GetMapping("/{currencyId}")
    public Currency findById(@PathVariable(name = "currencyId") UUID id)
    {
        return currencyService.findById(id);
    }

    @DeleteMapping("/{currencyId}")
    public String delete(@PathVariable(name = "currencyId") UUID id)
    {
        return currencyService.deleteCurrency(id);
    }

}
