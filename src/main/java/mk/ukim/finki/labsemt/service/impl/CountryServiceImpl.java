package mk.ukim.finki.labsemt.service.impl;

import mk.ukim.finki.labsemt.model.Country;
import mk.ukim.finki.labsemt.model.dto.CountryDto;
import mk.ukim.finki.labsemt.repository.CountryRepository;
import mk.ukim.finki.labsemt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country addCountry(CountryDto country) {
        Country c = new Country();
        c.setName(country.getName());
        return countryRepository.save(c);
    }

    @Override
    public Country editCountry(CountryDto country, Long id) {
        Country c = countryRepository.findById(id).orElse(null);

        if (c == null)
            return null;

        c.setName(country.getName());
        return countryRepository.save(c);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
