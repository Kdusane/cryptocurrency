package com.neosoft.currency.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@Table(schema = "crypto_currency")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Cryptocurrency extends BaseEntity{


}
