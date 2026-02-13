package codegym.mod5.bookstore;

import codegym.mod5.bookstore.model.Book;
import codegym.mod5.bookstore.repository.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookStoreConfig.class);

        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

        Book book = Book.builder()
                .title("Harry Potter y Piedra Filosofal")
                .author("J.K. Rowling")
                .isbn("123456789")
                .build();

        bookRepository.save(book);
    }
}
