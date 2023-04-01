package com.usermanagementservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.UUID;

@Data
public class BaseEntity {

    @Id
    private UUID id;
}
