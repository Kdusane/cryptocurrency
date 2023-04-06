package com.usermanagementservice.domain.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.UUID;

@Builder
public record UserResponse(UUID id, String firstName, String lastName, String mobileNumber, String emailId, String password, String status, String role,
                           BigInteger quantity) {
}
