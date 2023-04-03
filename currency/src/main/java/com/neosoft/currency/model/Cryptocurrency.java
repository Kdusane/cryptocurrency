package com.neosoft.currency.model;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;


@Data
@Builder
@Entity
@Table(name = "crypto_currency")
//@EqualsAndHashCode(callSuper=false)
public class Cryptocurrency extends BaseEntity{



}
