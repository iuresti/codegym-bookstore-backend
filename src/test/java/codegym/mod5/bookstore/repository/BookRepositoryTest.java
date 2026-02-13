package codegym.mod5.bookstore.repository;


import codegym.mod5.bookstore.BookStoreConfig;
import codegym.mod5.bookstore.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

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
        Book book = new Book();

        // When:
        Book savedBook = bookRepository.save(book);
        Book foundBook = bookRepository.findById(savedBook.getId());

        // Then:
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook).isEqualTo(foundBook);
    }

    @Test
    void delete() {
    }

    void findById() {
    }
}