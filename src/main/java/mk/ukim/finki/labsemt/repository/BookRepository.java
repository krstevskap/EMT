package mk.ukim.finki.labsemt.repository;

import mk.ukim.finki.labsemt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
