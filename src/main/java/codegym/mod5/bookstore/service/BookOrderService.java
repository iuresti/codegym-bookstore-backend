package codegym.mod5.bookstore.service;

import codegym.mod5.bookstore.dto.BookOrderDto;
import codegym.mod5.bookstore.dto.OrderItemDto;
import codegym.mod5.bookstore.exceptions.ValidationException;
import codegym.mod5.bookstore.model.Book;
import codegym.mod5.bookstore.model.BookOrder;
import codegym.mod5.bookstore.model.BooksByOrder;
import codegym.mod5.bookstore.model.OrderStatus;
import codegym.mod5.bookstore.repository.BookOrderRepository;
import codegym.mod5.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class BookOrderService {

    private final BookOrderRepository bookOrderRepository;

    private final BookRepository bookRepository;


    @Transactional
    public BookOrderDto save(BookOrderDto bookOrderDto) {
        BookOrder bookOrderEntity = BookOrder.builder()
                .id(bookOrderDto.getId() == null ? UUID.randomUUID().toString() : bookOrderDto.getId())
                .status(bookOrderDto.getOrderStatus())
                .clientId(bookOrderDto.getUserId())
                .build();
        bookOrderRepository.save(bookOrderEntity);

        bookOrderDto.setId(bookOrderEntity.getId());

        return bookOrderDto;
    }

    @Transactional
    public List<BookOrderDto> findAll() {
        return bookOrderRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void markCompleted(String orderId) {
        BookOrder bookOrder = bookOrderRepository.findById(orderId)
                .orElseThrow();

        if (OrderStatus.CANCELED.equals(bookOrder.getStatus())) {
            throw new ValidationException("Order has been cancelled");
        }

        bookOrder.setStatus(OrderStatus.COMPLETED);

        bookOrderRepository.save(bookOrder);
    }

    private BookOrderDto mapToDto(BookOrder entity) {
        BookOrderDto dto = new BookOrderDto();

        List<OrderItemDto> items = bookOrderRepository.getItems(entity.getId())
                .stream().map(this::mapToDto)
                .collect(Collectors.toList());

        dto.setId(entity.getId());
        dto.setOrderDate(entity.getCreationDate());
        dto.setOrderStatus(entity.getStatus());
        dto.setCompletedDate(entity.getLastUpdateDate());
        dto.setOrderStartDate(entity.getCreationDate());
        dto.setItems(items);

        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemDto item : items) {
            total = total.add(item.getPrice());
        }

        dto.setTotal(total);

        return dto;
    }

    private OrderItemDto mapToDto(BooksByOrder itemEntity) {

        Book book = bookRepository.findById(itemEntity.getBookId())
                .orElseThrow();

        return OrderItemDto.builder()
                .bookId(itemEntity.getBookId())
                .price(itemEntity.getPrice())
                .quantity(itemEntity.getQuantity())
                .title(book.getTitle())
                .build();
    }


}
