package com.usermanagementservice.reposiory;

import com.usermanagementservice.entity.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRespository extends JpaRepository<User, UUID> {
}
