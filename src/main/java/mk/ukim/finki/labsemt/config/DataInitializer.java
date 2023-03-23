package mk.ukim.finki.labsemt.config;


import jakarta.annotation.PostConstruct;
import mk.ukim.finki.labsemt.model.Author;
import mk.ukim.finki.labsemt.model.Book;
import mk.ukim.finki.labsemt.model.Country;
import mk.ukim.finki.labsemt.model.enumerations.Category;
import mk.ukim.finki.labsemt.repository.AuthorRepository;
import mk.ukim.finki.labsemt.repository.BookRepository;
import mk.ukim.finki.labsemt.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {

        Country c1 = new Country("Germany", "Europe");
        Country c2 = new Country("Iceland", "Europe");
        Country c3 = new Country("Brazil", "South America");
        countryRepository.save(c1);
        countryRepository.save(c2);
        countryRepository.save(c3);

        Author a1 = new Author("Sebastian", "Fitzek", c1);
        Author a2 = new Author("Yrsa", "Sigurðardóttir", c2);
        Author a3 = new Author("Chris", "Carter", c2);
        authorRepository.save(a1);
        authorRepository.save(a2);
        authorRepository.save(a3);

        bookRepository.save(new Book("Passenger 23", Category.THRILLER, a1, 3));
        bookRepository.save(new Book("The Inmate", Category.THRILLER, a1, 2));
        bookRepository.save(new Book("DNA", Category.THRILLER, a2, 4));
        bookRepository.save(new Book("The Doll", Category.THRILLER, a2, 1));
        bookRepository.save(new Book("The Hunter", Category.THRILLER, a3, 3));
        bookRepository.save(new Book("One by One", Category.THRILLER, a3, 2));

    }
}