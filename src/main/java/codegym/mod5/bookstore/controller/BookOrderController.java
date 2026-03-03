package codegym.mod5.bookstore.controller;

import codegym.mod5.bookstore.dto.BookOrderDto;
import codegym.mod5.bookstore.service.BookOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequestMapping("/orders")
@RestController
@CrossOrigin
@AllArgsConstructor
public class BookOrderController {

    private final BookOrderService bookOrderService;

    @GetMapping
    public List<BookOrderDto> findAll() {

        log.info("Find all book orders");

        List<BookOrderDto> allOrders = Collections.emptyList();

        allOrders = bookOrderService.findAll();

        return allOrders;
    }
}
