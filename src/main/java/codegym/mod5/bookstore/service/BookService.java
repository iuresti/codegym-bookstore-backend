package codegym.mod5.bookstore.service;

import codegym.mod5.bookstore.dto.BookDto;
import codegym.mod5.bookstore.model.Book;
import codegym.mod5.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class BookService {

    private static final int DEFAULT_RATING = 5;

    private final BookRepository bookRepository;

    @Transactional
    public void save(BookDto bookDto) {

        Book bookEntity = new Book();

        BeanUtils.copyProperties(bookDto, bookEntity);

        if (bookEntity.getId() == null) {
            bookEntity.setId(UUID.randomUUID().toString());
        }

        bookRepository.save(bookEntity);
    }

    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(entity -> {
                    BookDto bookDto = new BookDto();

                    BeanUtils.copyProperties(entity, bookDto);

                    bookDto.setRating(DEFAULT_RATING);

                    return bookDto;
                })
                .collect(Collectors.toList());
    }

    public void delete(String id) {
        int removedCount = bookRepository.deleteById(id);

        log.debug("Removed Book with id: {}, count: {} ", id, removedCount);
    }

    public BookDto getById(String id){
        Book bookEntity = bookRepository.findById(id);
        BookDto bookDto = new BookDto();

        BeanUtils.copyProperties(bookEntity, bookDto);

        return bookDto;
    }
}
