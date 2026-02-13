package codegym.mod5.bookstore.repository;

import codegym.mod5.bookstore.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(UUID.randomUUID().toString());
        }

        entityManager.persist(book);

        return book;
    }

    public void delete(Book book) {
        entityManager.remove(book);
    }

    public Book findById(String id) {
        Query query = entityManager.createQuery("select b from Book b where b.id = :id");

        query.setParameter("id", id);

        return (Book) query.getSingleResult();
    }


}
