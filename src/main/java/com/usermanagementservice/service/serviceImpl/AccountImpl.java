package com.usermanagementservice.service.serviceImpl;

import com.usermanagementservice.constants.ConstantUtils;
import com.usermanagementservice.domain.helper.AccountHelper;
import com.usermanagementservice.domain.requestDTOs.account.AccountRequestDto;
import com.usermanagementservice.domain.response.AccountResponse;
import com.usermanagementservice.domain.response.BaseResponse;
import com.usermanagementservice.entity.Account;
import com.usermanagementservice.entity.Users;
import com.usermanagementservice.exception.NotFoundException;
import com.usermanagementservice.repository.AccountRepository;
import com.usermanagementservice.repository.UserRespository;
import com.usermanagementservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service

public class AccountImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRespository userRespository;

    @Override
    public BaseResponse createAccount(AccountRequestDto requestDto) {


        Optional<Account> accountDetails = accountRepository.findByAccountNumber(requestDto.getAccountNumber());
        Optional<Users> user = userRespository.findById(requestDto.getUser_id());
        if (!user.isPresent()) {
            throw new NotFoundException(ConstantUtils.USER_NOT_FOUND);
        } else {
            if (accountDetails.isPresent()) {
                throw new NotFoundException(ConstantUtils.ACCOUNT_ALREADY_EXIST);
            }
        }
        Account account = AccountHelper.requestDtoToEntity(requestDto, user.get());
        accountRepository.save(account);
        AccountResponse response = AccountHelper.entityToResponse(account);

        return new BaseResponse(HttpStatus.CREATED.value(), ConstantUtils.ACCOUNT_CREATED_SUCCESSFULLY,ConstantUtils.ACCOUNT_CREATED_SUCCESSFULLY,response,null);
    }

    @Override
    public BaseResponse findAccountById(UUID id) {
        Optional<Account> accountdetails = accountRepository.findById(id);
        if (!accountdetails.isPresent()) {
            throw new NotFoundException(ConstantUtils.ACCOUNT_NOT_FOUND);
        }
        AccountResponse response = AccountHelper.entityToResponse(accountdetails.get());
        return new BaseResponse(HttpStatus.OK.value(), ConstantUtils.USER_RETRIEVE_SUCCESSFULLY, ConstantUtils.USER_RETRIEVE_SUCCESSFULLY,response,null);

    }

    @Override
    public BaseResponse findBalanaceByAccountNumber(String accountNumber) {
        Optional<Account> account = accountRepository.findBalanceByAccountNumber(accountNumber);
        if (!account.isPresent()) {
            throw new NotFoundException(ConstantUtils.ACCOUNT_NOT_FOUND);
        }
        var balance = account.get().getAccountBalance();
        return new BaseResponse(HttpStatus.OK.value(), ConstantUtils.ACCOUNT_BALANCE, ConstantUtils.ACCOUNT_BALANCE,balance,null);
    }

    @Override
    public BaseResponse addAccountBalanaceByAccountNumber(BigInteger balance, String accountNumber) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
        if (!account.isPresent()) {
            throw new NotFoundException(ConstantUtils.ACCOUNT_NOT_FOUND);
        }
        account.get().setAccountBalance(account.get().getAccountBalance().add(balance));
        log.info("account balance : " + account.get().getAccountBalance());
        accountRepository.save(account.get());
        return new BaseResponse(HttpStatus.OK.value(), ConstantUtils.ACCOUNT_BALANCE_UPDATED_SUCCESSFULLY, ConstantUtils.ACCOUNT_BALANCE_UPDATED_SUCCESSFULLY,account.get(),null);
    }
}
