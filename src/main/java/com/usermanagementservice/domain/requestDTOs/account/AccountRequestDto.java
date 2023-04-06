package com.usermanagementservice.domain.requestDTOs.account;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestDto {
    @Pattern(regexp = "^[0-9]{9,18}$", message = "enter valid account Number")
    @NotNull(message = "account number is not null")
    private String accountNumber;
    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "enter valid IFSC code")

    private String ifscCode;
    @NotNull(message = "branch code is not null")


    private String branchCode;
    @NotNull(message = "branch Name is not null")
    private String branchName;

    private BigInteger accountBalance;

    @NotNull(message = " user id  is not null")
    private UUID user_id;

}
