package mk.ukim.finki.labsemt.repository;

import mk.ukim.finki.labsemt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}