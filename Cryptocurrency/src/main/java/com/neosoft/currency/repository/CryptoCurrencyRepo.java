package com.neosoft.currency.repository;




import com.neosoft.currency.model.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CryptoCurrencyRepo extends JpaRepository<Cryptocurrency, UUID> {
    Cryptocurrency findByName(String name);
}
