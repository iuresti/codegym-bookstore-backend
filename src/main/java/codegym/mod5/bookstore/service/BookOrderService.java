package codegym.mod5.bookstore.service;

import codegym.mod5.bookstore.dto.BookOrderDto;
import codegym.mod5.bookstore.dto.OrderItem;
import codegym.mod5.bookstore.model.Book;
import codegym.mod5.bookstore.model.BookOrder;
import codegym.mod5.bookstore.model.BooksByOrder;
import codegym.mod5.bookstore.repository.BookOrderRepository;
import codegym.mod5.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class BookOrderService {

    private final BookOrderRepository bookOrderRepository;

    private final BookRepository bookRepository;

    @Transactional
    public List<BookOrderDto> findAll() {
        return bookOrderRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private BookOrderDto mapToDto(BookOrder entity) {
        BookOrderDto dto = new BookOrderDto();

        List<OrderItem> items = bookOrderRepository.getItems(entity.getId())
                .stream().map(this::mapToDto)
                .collect(Collectors.toList());

        dto.setId(entity.getId());
        dto.setOrderDate(entity.getCreationDate());
        dto.setOrderStatus(entity.getStatus());
        dto.setCompletedDate(entity.getLastUpdateDate());
        dto.setOrderStartDate(entity.getCreationDate());
        dto.setItems(items);

        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : items) {
            total = total.add(item.getPrice());
        }

        dto.setTotal(total);

        return dto;
    }

    private OrderItem mapToDto(BooksByOrder itemEntity) {

        Book book = bookRepository.findById(itemEntity.getBookId());

        return OrderItem.builder()
                .bookId(itemEntity.getBookId())
                .price(itemEntity.getPrice())
                .quantity(itemEntity.getQuantity())
                .title(book.getTitle())
                .build();
    }


}
