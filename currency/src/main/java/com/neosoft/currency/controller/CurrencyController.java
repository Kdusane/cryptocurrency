package com.neosoft.currency.controller;

import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CurrencyDTO;
import com.neosoft.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @PostMapping()
    public ResponseEntity<BaseResponse> saveCurrency(@RequestBody CurrencyDTO currencyDTO) throws Exception {
       return currencyService.saveCurrency(currencyDTO);
    }

    @GetMapping()
    public ResponseEntity<BaseResponse> findAllCurrency()
    {

        return currencyService.findAllCurrency();
    }

    @GetMapping("/{currencyId}")
    public ResponseEntity<BaseResponse> findByCurrencyId(@PathVariable(name = "currencyId") UUID id) throws Exception {
        return currencyService.findByCurrencyId(id);
    }

    @DeleteMapping("/{currencyId}")
    public ResponseEntity<BaseResponse> delete(@PathVariable(name = "currencyId") UUID id) throws Exception {
        return currencyService.deleteCurrency(id);
    }

    @PutMapping("/{currencyId}")
    public ResponseEntity<BaseResponse> update(@PathVariable(name = "currencyId") UUID id,@RequestBody CurrencyDTO currencyDTO) throws Exception {
        return currencyService.updateCurrency(id,currencyDTO);
    }


}
