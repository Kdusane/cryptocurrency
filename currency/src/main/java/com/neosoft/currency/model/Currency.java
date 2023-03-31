package com.neosoft.currency.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Data
@Builder
@Table(schema = "currency")
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Currency extends BaseEntity {
    private String country;
}
