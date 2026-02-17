package codegym.mod5.bookstore;

import codegym.mod5.bookstore.repository.BookOrderRepository;
import codegym.mod5.bookstore.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookStoreConfig.class);

    }
}
