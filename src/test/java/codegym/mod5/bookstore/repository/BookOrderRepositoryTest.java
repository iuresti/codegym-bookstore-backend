package codegym.mod5.bookstore.repository;

import codegym.mod5.bookstore.BookStoreConfig;
import codegym.mod5.bookstore.model.BookOrder;
import codegym.mod5.bookstore.model.OrderStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BookStoreConfig.class)
@Transactional
class BookOrderRepositoryTest {

    @Autowired
    private BookOrderRepository bookOrderRepository;

    @Test
    void findAll() {
    }

    @Test
    void getItems() {
    }

    @Test
    void save() {
        // Given:
        BookOrder order = BookOrder.builder()
                .id(UUID.randomUUID().toString())
                .clientId(UUID.randomUUID().toString())
                .status(OrderStatus.NEW)
                .build();

        // When:
        bookOrderRepository.save(order);
        Optional<BookOrder> savedOrder = bookOrderRepository.findById(order.getId());

        // Then:
        assertThat(savedOrder).isPresent();
        savedOrder.ifPresent(bookOrder -> {
           assertThat(bookOrder.getStatus()).isEqualTo(OrderStatus.NEW);
           assertThat(bookOrder.getClientId()).isEqualTo(order.getClientId());
        });

    }
}