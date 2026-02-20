package codegym.mod5.bookstore.repository;

import codegym.mod5.bookstore.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Book save(Book book) {

        entityManager.persist(book);

        return book;
    }

    public Optional<Book> findById(String id) {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b where b.id = :id", Book.class);

        query.setParameter("id", id);

        List<Book> resultList = query.getResultList();
        if(resultList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(resultList.getFirst());
    }

    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);

        return query.getResultList();
    }


    public int deleteById(String id) {
        return entityManager.createQuery("delete from Book b where b.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
