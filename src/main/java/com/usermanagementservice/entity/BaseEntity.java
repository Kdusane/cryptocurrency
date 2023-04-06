package com.usermanagementservice.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.domain.Persistable;

import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity implements Persistable<UUID> {

    @Id
    private UUID id;

    @Override
    public boolean isNew() {
        boolean result = Objects.isNull(id);
        this.id = result ? UUID.randomUUID() : this.id;
        return result;
    }
}
