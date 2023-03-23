package mk.ukim.finki.labsemt.service.impl;

import mk.ukim.finki.labsemt.model.Author;
import mk.ukim.finki.labsemt.model.Book;
import mk.ukim.finki.labsemt.model.dto.BookDto;
import mk.ukim.finki.labsemt.repository.BookRepository;
import mk.ukim.finki.labsemt.service.AuthorService;
import mk.ukim.finki.labsemt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(BookDto book) {
        Book b = new Book();
        Author a = authorService.findById(book.getAuthor());
        b.setName(book.getName());
        b.setCategory(book.getCategory());
        b.setAuthor(a);
        b.setAvailableCopies(book.getAvailableCopies());

        return bookRepository.save(b);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book editBook(Long id, BookDto book) {
        Book b = bookRepository.findById(id).orElse(null);

        if(b==null)
            return null;

        Author a = authorService.findById(book.getAuthor());
        b.setName(book.getName());
        b.setCategory(book.getCategory());
        b.setAuthor(a);
        b.setAvailableCopies(book.getAvailableCopies());
        return bookRepository.save(b);
    }

    @Override
    public void markAsTaken(Long id) {
        Book book = bookRepository.findById(id).orElse(null);

        if (book == null)
            return;
        book.setAvailableCopies(book.getAvailableCopies() - 1);

        bookRepository.save(book);
    }
}
