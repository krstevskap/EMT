package mk.ukim.finki.labsemt.service;

import mk.ukim.finki.labsemt.model.Author;
import mk.ukim.finki.labsemt.model.Country;
import mk.ukim.finki.labsemt.model.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(Long id);
    Author addAuthor(AuthorDto author);
    Author editAuthor(Long id, AuthorDto author);
    void deleteAuthor(Long id);
}
