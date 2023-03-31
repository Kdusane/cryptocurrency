package com.neosoft.currency.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import java.util.Objects;
import java.util.UUID;

@Data
public class BaseEntity implements Persistable<UUID> {
    @Id
    private UUID id;
    private String name;
    private String symbol;
    private double quotation;

    @Override
    public boolean isNew() {
        boolean result = Objects.isNull(id);
        this.id = result ? UUID.randomUUID() : this.id;
        return result;
    }
}
