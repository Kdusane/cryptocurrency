package com.usermanagementservice.entity;


import com.usermanagementservice.domain.enums.Role;
import com.usermanagementservice.domain.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigInteger;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class Users extends BaseEntity {
    private String firstName;
    private String lastName;

    private String mobileNumber;

    private String emailId;

    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Role role;
    private BigInteger quantity;


}
