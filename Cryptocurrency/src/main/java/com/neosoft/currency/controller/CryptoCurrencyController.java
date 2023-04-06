package com.neosoft.currency.controller;

import com.neosoft.currency.domain.BaseResponse;
import com.neosoft.currency.domain.requestDTO.CryptoCurrencyDTO;
import com.neosoft.currency.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cryptoCurrency")
public class CryptoCurrencyController {
    @Autowired
    CryptoCurrencyService cryptoCurrencyService;

    @PostMapping()
    public ResponseEntity<BaseResponse> saveCryptoCurrency(@RequestBody CryptoCurrencyDTO cryptoCurrencyDTO)  {
        return cryptoCurrencyService.saveCryptoCurrency(cryptoCurrencyDTO);
    }

    @GetMapping()
    public ResponseEntity<BaseResponse> findAllCryptoCurrency()
    {
        return cryptoCurrencyService.findAllCryptoCurrency();
    }

    @GetMapping("/{cryptoCurrencyId}")
    public ResponseEntity<BaseResponse> findByCryptoCurrencyId(@PathVariable(name = "cryptoCurrencyId") UUID id)  {
        return cryptoCurrencyService.findByCryptoCurrencyId(id);
    }

    @DeleteMapping("/{cryptoCurrencyId}")
    public ResponseEntity<BaseResponse> deleteCryptoCurrency(@PathVariable(name = "cryptoCurrencyId") UUID id)  {
        return cryptoCurrencyService.deleteCryptoCurrency(id);
    }
    @PutMapping("/{cryptoCurrencyId}")
    public ResponseEntity<BaseResponse> update(@PathVariable(name = "cryptoCurrencyId") UUID id,@RequestBody CryptoCurrencyDTO cryptoCurrencyDTO)  {
        return cryptoCurrencyService.updateByCryptoCurrency(id,cryptoCurrencyDTO);
    }


}
