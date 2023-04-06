package com.usermanagementservice.controller;

import com.usermanagementservice.domain.requestDTOs.account.AccountRequestDto;
import com.usermanagementservice.domain.response.BaseResponse;
import com.usermanagementservice.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping()
    public ResponseEntity<BaseResponse> createAccount(@RequestBody @Valid AccountRequestDto requestDto) {
        log.info("account detail created " + requestDto);
        return ResponseEntity.ok().body(accountService.createAccount(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> findAccountById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(accountService.findAccountById(id));

    }

    @GetMapping("/accountNumber/{accountNumber}")
    public ResponseEntity<BaseResponse> findAccountBalanceByAccountNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok().body(accountService.findBalanaceByAccountNumber(accountNumber));
    }

    @PutMapping("/updatebalance/{accountNumber}/{balance}")
    public ResponseEntity<BaseResponse> updateAccountBalance(@PathVariable String accountNumber, @PathVariable BigInteger balance) {
        return ResponseEntity.ok().body(accountService.addAccountBalanaceByAccountNumber(balance, accountNumber));
    }

}
