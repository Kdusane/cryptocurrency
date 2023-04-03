package com.neosoft.currency.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Builder
@Entity
@Table(name = "currency")
//@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Currency extends BaseEntity {
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "currencyId",referencedColumnName = "id")
    private List<Cryptocurrency> cryptocurrency;
    private String country;
}
