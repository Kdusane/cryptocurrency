package com.usermanagementservice.domain.helper;

import com.usermanagementservice.domain.requestDTOs.account.AccountRequestDto;
import com.usermanagementservice.domain.response.AccountResponse;
import com.usermanagementservice.entity.Account;
import com.usermanagementservice.entity.Users;

import java.util.UUID;

public class AccountHelper {

    AccountHelper() {
    }

    public static Account requestDtoToEntity(AccountRequestDto requestDto, Users users) {
        Account account = Account.builder().accountNumber(requestDto.getAccountNumber()).branchCode(requestDto.getBranchCode()).accountBalance(requestDto.getAccountBalance()).user(users).branchName(requestDto.getBranchName()).ifscCode(requestDto.getIfscCode()).build();
        account.setId(UUID.randomUUID());
        return account;

    }

    public static AccountResponse entityToResponse(Account account) {
        return AccountResponse.builder().id(account.getId()).accountNumber(account.getAccountNumber()).accountBalance(account.getAccountBalance()).branchCode(account.getBranchCode()).branchName(account.getBranchName()).ifscCode(account.getIfscCode()).user(account.getUser()).build();
    }
}
