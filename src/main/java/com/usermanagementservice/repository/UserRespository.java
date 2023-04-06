package com.usermanagementservice.repository;

import com.usermanagementservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRespository extends JpaRepository<Users, UUID> {

     Optional<Users> findById(UUID id);
}
