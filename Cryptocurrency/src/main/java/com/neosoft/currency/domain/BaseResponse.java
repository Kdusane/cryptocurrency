package com.neosoft.currency.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BaseResponse<T> {
    private int statusCode;
    private String message;
    private T data;
}
