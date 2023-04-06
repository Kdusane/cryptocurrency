package com.usermanagementservice.domain.response;

import com.usermanagementservice.entity.Users;
import lombok.Builder;

import java.math.BigInteger;
import java.util.UUID;



@Builder
public record AccountResponse(UUID id, String accountNumber, String ifscCode, String branchCode, String branchName,
                              BigInteger accountBalance, Users user) {
}
