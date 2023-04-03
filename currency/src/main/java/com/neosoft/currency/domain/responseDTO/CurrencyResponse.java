package com.neosoft.currency.domain.responseDTO;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CurrencyResponse(UUID id,String name, String symbol,double quotation,String country) {
}
