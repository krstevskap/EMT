package mk.ukim.finki.labsemt.service;

import mk.ukim.finki.labsemt.model.Author;
import mk.ukim.finki.labsemt.model.Book;
import mk.ukim.finki.labsemt.model.dto.BookDto;
import mk.ukim.finki.labsemt.model.enumerations.Category;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book getBookById(Long id);
    Book addBook(BookDto book);
    void deleteBook(Long id);
    Book editBook(Long id, BookDto book);
    void markAsTaken(Long id);
}
