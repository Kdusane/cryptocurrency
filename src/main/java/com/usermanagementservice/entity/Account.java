package com.usermanagementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "accounts")
public class Account extends BaseEntity{


private String accountNumber;

private String ifscCode;


private String branchCode;


private String branchName;

private BigInteger accountBalance;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "user_id")
private Users user;
}
