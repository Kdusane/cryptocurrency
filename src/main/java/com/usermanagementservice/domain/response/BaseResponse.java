package com.usermanagementservice.domain.response;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BaseResponse<T> {
    private int status;
    private String message;
    private String supportDescriptiveMessage;
    private Object data;
    private Object error;
}
