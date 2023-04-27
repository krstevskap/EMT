package mk.ukim.finki.labsemt.web;

import mk.ukim.finki.labsemt.model.Country;
import mk.ukim.finki.labsemt.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    private List<Country> findAll() {
        return this.countryService.findAll();
    }


}


