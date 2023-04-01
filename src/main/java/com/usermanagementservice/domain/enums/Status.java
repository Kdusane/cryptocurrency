package com.usermanagementservice.domain.enums;

public enum Status {
    INACTIVE("INACTIVE"), ACTIVE("ACTIVE"),DELETED("DELETED");

    private final String name;

    Status(String name){
        this.name = name;
    }
}

