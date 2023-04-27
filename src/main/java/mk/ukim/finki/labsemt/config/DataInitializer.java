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
        Country c3 = new Country("Pennsylvania", "United States");
        Country c4 = new Country("United Kingdom", "Europe");
        Country c5 = new Country("Illinois", "North America");
        Country c6= new Country("Argentina", "South America");
        Country c7= new Country("Ireland", "Europe");

        countryRepository.save(c1);
        countryRepository.save(c2);
        countryRepository.save(c3);
        countryRepository.save(c4);
        countryRepository.save(c5);
        countryRepository.save(c6);
        countryRepository.save(c7);

        Author a1 = new Author("Sebastian", "Fitzek", c1);
        Author a2 = new Author("Yrsa", "Sigurðardóttir", c2);
        Author a3 = new Author("Riley", "Sager", c3);
        Author a4 = new Author("Sidney", "Sheldon", c5);
        Author a5 = new Author("Alex", "Michaelides", c4);
        Author a6 = new Author("Guillermo", "Martínez", c6);
        Author a7 = new Author("Mary", "Shelley", c4);
        Author a8 = new Author("Oscar", "Wilde", c7);

        authorRepository.save(a1);
        authorRepository.save(a2);
        authorRepository.save(a3);
        authorRepository.save(a4);
        authorRepository.save(a5);
        authorRepository.save(a6);
        authorRepository.save(a7);
        authorRepository.save(a8);

        bookRepository.save(new Book("The Nightwalker", Category.THRILLER, a1, 9));
        bookRepository.save(new Book("The Eye Collector", Category.THRILLER, a1, 13));
        bookRepository.save(new Book("Therapy", Category.THRILLER, a1, 8));
        bookRepository.save(new Book("The Silent Patient", Category.THRILLER, a5, 5));
        bookRepository.save(new Book("DNA", Category.THRILLER, a2, 6));
        bookRepository.save(new Book("The Oxford Murders", Category.THRILLER, a4, 11));
        bookRepository.save(new Book("Home Before Dark", Category.THRILLER, a3, 8));
        bookRepository.save(new Book("Tell Me Your Dreams", Category.THRILLER, a4, 7));
        bookRepository.save(new Book("Frankenstein", Category.NOVEL, a7, 10));
        bookRepository.save(new Book("The Picture of Dorian Gray", Category.NOVEL, a8, 5));


    }
}