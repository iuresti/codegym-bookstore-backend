package codegym.mod5.bookstore.service;

import codegym.mod5.bookstore.dto.BookOrderDto;
import codegym.mod5.bookstore.model.Book;
import codegym.mod5.bookstore.model.BookOrder;
import codegym.mod5.bookstore.model.OrderStatus;
import codegym.mod5.bookstore.repository.BookOrderRepository;
import codegym.mod5.bookstore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.exceptions.base.MockitoException;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BookOrderServiceTest {

    private BookOrderService bookOrderService;

    private BookRepository mockBookRepository;

    private BookOrderRepository mockBookOrderRepository;

    @BeforeEach
    void setUp() {
        mockBookRepository = mock(BookRepository.class);
        mockBookOrderRepository = mock(BookOrderRepository.class);

        bookOrderService = new BookOrderService(mockBookOrderRepository, mockBookRepository);
    }

    @Test
    void save() {
        // Given:
        BookOrderDto dto = BookOrderDto.builder()
                .orderStatus(OrderStatus.COMPLETED)
                .userId(UUID.randomUUID().toString())
                .build();

        // When:
        bookOrderService.save(dto);

        // Then:
        ArgumentCaptor<BookOrder> captor = ArgumentCaptor.forClass(BookOrder.class);
        verify(mockBookOrderRepository).save(captor.capture());
        BookOrder value = captor.getValue();

        assertThat(value.getStatus()).isEqualTo(OrderStatus.COMPLETED);
        assertThat(value.getId()).isNotNull();
        assertThat(value.getClientId()).isEqualTo(dto.getUserId());
    }

    @Test
    void findAll() {
    }

    @Test
    void markCompleted() {
    }
}