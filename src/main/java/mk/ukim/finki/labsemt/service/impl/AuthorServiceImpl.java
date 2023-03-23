package mk.ukim.finki.labsemt.service.impl;

import mk.ukim.finki.labsemt.model.Author;
import mk.ukim.finki.labsemt.model.Country;
import mk.ukim.finki.labsemt.model.dto.AuthorDto;
import mk.ukim.finki.labsemt.repository.AuthorRepository;
import mk.ukim.finki.labsemt.service.AuthorService;
import mk.ukim.finki.labsemt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author addAuthor(AuthorDto author) {
        Author a = new Author();
        Country country = countryService.findById(a.getCountry().getId());

        if (country == null)
            return null;

        a.setName(author.getName());
        a.setSurname(author.getSurname());
        a.setCountry(country);

        return authorRepository.save(a);
    }

    @Override
    public Author editAuthor(Long id, AuthorDto author) {
        Author a = authorRepository.findById(id).orElse(null);

        if(a==null)
            return null;

        Country country = countryService.findById(a.getCountry().getId());

        if (country == null)
            return null;

        a.setName(author.getName());
        a.setSurname(author.getSurname());
        a.setCountry(country);

        return authorRepository.save(a);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}

