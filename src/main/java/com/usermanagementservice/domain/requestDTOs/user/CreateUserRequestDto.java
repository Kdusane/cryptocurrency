package com.usermanagementservice.domain.requestDTOs.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequestDto {
    @NotNull(message = "Enter valid id ")
    private UUID id;
    @NotNull(message = "Enter  vallid FirstName")
    private String firstName;
    @NotNull(message = "Enter valid lastname")

    private String lastName;
    @NotNull(message = "Enter valid Mobile Number")
    @Pattern(regexp = "^[6789]\\d{9}$", message = "Mobile number should contain 10 digits")

    private String mobileNumber;
    @Pattern(regexp = "(^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$)", message = "Enter valid Email-Id")
    @NotEmpty(message = "Enter valid Email-Id")

    private String emailId;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{10,20}$",
            message = "Password must contain atleast 1 Uppercase, 1 Lowercase, 1 Special character and 1 Digit. Password size must be min 10 and max 20")
    @NotEmpty(message = "Enter valid Password")

    private String password;
    @NotNull(message = "Enter valid status")

    private String status;
    @NotNull(message = "Enter valid roles ")

    private String role;

    private BigInteger quantity;
}
