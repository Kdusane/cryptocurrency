package com.usermanagementservice.domain.requestDTOs.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequestDto {

    @NotNull(message = "Enter valid firstname")
    private String firstName;
    @NotNull(message = "Enter valid lastname")
    private String lastName;
    @NotNull(message = "Enter valid Mobile Number")
    @Pattern(regexp = "^[6789]\\d{9}$", message = "Mobile number should contain 10 digits")

    private String mobileNumber;
    @Pattern(regexp = "(^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$)", message = "Enter valid Email-Id")
    @NotEmpty(message = "Enter valid Email-Id")
    private String emailId;

}
