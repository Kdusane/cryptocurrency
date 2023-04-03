package com.neosoft.currency.domain.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyDTO {
    private UUID id;
    private String name;
    private String symbol;
    private double quotation;
    private String country;
    private List<CryptoCurrencyDTO> cryptoCurrencyDTOS;
}