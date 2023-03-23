package mk.ukim.finki.labsemt.repository;

import mk.ukim.finki.labsemt.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
