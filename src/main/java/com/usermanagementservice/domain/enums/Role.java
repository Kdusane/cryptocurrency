package com.usermanagementservice.domain.enums;

public enum Role {

    USER("USER"),AGENT("AGENT");

    private final String name;

    Role(String name){
        this.name = name;
    }
}
