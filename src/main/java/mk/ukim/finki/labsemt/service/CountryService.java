package mk.ukim.finki.labsemt.service;

import mk.ukim.finki.labsemt.model.Country;
import mk.ukim.finki.labsemt.model.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Country findById(Long id);
    Country addCountry(CountryDto country);
    Country editCountry(CountryDto country, Long id);
    void deleteCountry(Long id);
}
