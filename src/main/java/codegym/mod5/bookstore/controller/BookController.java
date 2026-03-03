package codegym.mod5.bookstore.controller;


import codegym.mod5.bookstore.dto.BookDto;
import codegym.mod5.bookstore.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("/books")
@RestController
@Slf4j
@CrossOrigin
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody BookDto book) {

        return new ResponseEntity<>(bookService.save(book), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<BookDto> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable("id") String bookId, HttpSession httpSession) {
        return bookService.getById(bookId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String bookId) {

        try {
            bookService.delete(bookId);
        } catch (Exception e) {
            log.error("Failed to delete book with id: {}", bookId, e);
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") String bookId, @RequestBody BookDto book) {

        try {
            book.setId(bookId);
            return new ResponseEntity<>(bookService.update(book), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            log.error("Book was not found: {}", bookId);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("Failed to update book with id: {}", bookId, e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
