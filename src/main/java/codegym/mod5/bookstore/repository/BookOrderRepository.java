package codegym.mod5.bookstore.repository;

import codegym.mod5.bookstore.model.Book;
import codegym.mod5.bookstore.model.BookOrder;
import codegym.mod5.bookstore.model.BooksByOrder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookOrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<BookOrder> findAll() {

        return entityManager.createQuery("from BookOrder", BookOrder.class)
                .getResultList();

    }

    public List<BooksByOrder> getItems(String orderId) {

        entityManager.createQuery("select bo from BooksByOrder bo where bo.orderId = :orderId", BooksByOrder.class)
                .setParameter("orderId", orderId).getResultList();

        return null;
    }

    public Optional<BookOrder> findById(String id) {
        TypedQuery<BookOrder> query = entityManager.createQuery("select b from BookOrder b where b.id = :id", BookOrder.class);

        query.setParameter("id", id);


        List<BookOrder> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(resultList.getFirst());
    }

    public void save(BookOrder bookOrder) {
        entityManager.persist(bookOrder);
    }
}
