package com.usermanagementservice.service;

import com.usermanagementservice.domain.requestDTOs.account.AccountRequestDto;
import com.usermanagementservice.domain.response.BaseResponse;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;

import java.math.BigInteger;
import java.util.UUID;

public interface AccountService {
    BaseResponse createAccount(AccountRequestDto requestDto);

    BaseResponse findAccountById(UUID id);

    BaseResponse findBalanaceByAccountNumber(String accountNumber);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    BaseResponse addAccountBalanaceByAccountNumber(BigInteger balance, String accountNumber);


}
