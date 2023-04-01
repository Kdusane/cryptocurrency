package com.usermanagementservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Account extends BaseEntity{

@Pattern(regexp = "^[0-9]{9,18}$",message = "enter vailid account Number")
private int accountNumber;
@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$",message = "enter vailid IFSC code")

private String ifscCode;


private String branchCode;


private String branchName;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "user_id")
private User user;
}
