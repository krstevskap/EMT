package mk.ukim.finki.labsemt.web;

import mk.ukim.finki.labsemt.model.Country;
import mk.ukim.finki.labsemt.model.dto.CountryDto;
import mk.ukim.finki.labsemt.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("list-countries")
    private List<Country> findAll() {
        return this.countryService.findAll();
    }


}


