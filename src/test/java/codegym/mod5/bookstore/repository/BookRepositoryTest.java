package codegym.mod5.bookstore.repository;


import codegym.mod5.bookstore.BookStoreConfig;
import codegym.mod5.bookstore.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BookStoreConfig.class)
@Transactional
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void save() {
        // Given:
        Book book = Book.builder()
                .id(UUID.randomUUID().toString())
                .genre("Novela")
                .title("El Quijote")
                .author("Miguel de Cervantes")
                .stock(5)
                .description("La historia de Don Quijote, el caballero andante más famoso de la literatura española.")
                .price(new BigDecimal("24.99"))
                .publishDate(LocalDate.of(1999, 10, 10))
                .build();


        // When:
        Book savedBook = bookRepository.save(book);
        Book foundBook = bookRepository.findById(savedBook.getId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Then:
        assertThat(savedBook).isEqualTo(foundBook);
    }

    @Test
    void delete() {
        // Given:
        Book book = Book.builder()
                .id(UUID.randomUUID().toString())
                .genre("Novela")
                .title("El Quijote")
                .author("Miguel de Cervantes")
                .stock(5)
                .description("La historia de Don Quijote, el caballero andante más famoso de la literatura española.")
                .price(new BigDecimal("24.99"))
                .publishDate(LocalDate.of(1999, 10, 10))
                .build();

        Book savedBook = bookRepository.save(book);

        // When:
        int affectedRows = bookRepository.deleteById(savedBook.getId());
        Optional<Book> optionalBook = bookRepository.findById(savedBook.getId());

        // Then:
        assertThat(affectedRows).isEqualTo(1);
        assertThat(optionalBook).isEmpty();
    }

    @Test
    void findAllWhenNoBooksThenListIsEmpty() {

        // when:
        List<Book> allBooks = bookRepository.findAll();

        assertThat(allBooks.isEmpty()).isTrue();
    }

    @Test
    void findAllWhenBooksThenListIsNotEmpty() {

        // Given:
        Book book = Book.builder()
                .id(UUID.randomUUID().toString())
                .genre("Novela")
                .title("El Quijote")
                .author("Miguel de Cervantes")
                .stock(5)
                .description("La historia de Don Quijote, el caballero andante más famoso de la literatura española.")
                .price(new BigDecimal("24.99"))
                .publishDate(LocalDate.of(1999, 10, 10))
                .build();

        Book savedBook1 = bookRepository.save(book);

        Book book2 = Book.builder()
                .id(UUID.randomUUID().toString())
                .genre("Novela")
                .title("El Quijote 2")
                .author("Miguel de Cervantes")
                .stock(3)
                .description("La historia de Don Quijote, el caballero andante más famoso de la literatura española.")
                .price(new BigDecimal("24.99"))
                .publishDate(LocalDate.of(1999, 10, 10))
                .build();

        Book savedBook2 = bookRepository.save(book2);

        // when:
        List<Book> allBooks = bookRepository.findAll();

        assertThat(allBooks).asList().containsExactlyInAnyOrder(savedBook1, savedBook2);
    }
}