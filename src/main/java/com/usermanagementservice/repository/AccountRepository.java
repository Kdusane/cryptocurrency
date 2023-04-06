package com.usermanagementservice.repository;

import com.usermanagementservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findByAccountNumber(String accountNumber);

    @Query(value = "select * from accounts where account_number = :accountNumber",nativeQuery = true)
    Optional<Account> findBalanceByAccountNumber(@Param("accountNumber") String accountNumber);
}
