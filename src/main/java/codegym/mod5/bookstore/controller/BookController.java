package codegym.mod5.bookstore.controller;


import codegym.mod5.bookstore.dto.BookDto;
import codegym.mod5.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public @ResponseBody BookDto save(@RequestBody BookDto book) {
        return bookService.save(book);
    }

    @GetMapping
    public List<BookDto> findAll() {
        return bookService.findAll();
    }
}
