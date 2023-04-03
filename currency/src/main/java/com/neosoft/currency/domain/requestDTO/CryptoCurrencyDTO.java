package com.neosoft.currency.domain.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CryptoCurrencyDTO {
    private UUID id;
    private String name;
    private String symbol;
    private double quotation;
}
