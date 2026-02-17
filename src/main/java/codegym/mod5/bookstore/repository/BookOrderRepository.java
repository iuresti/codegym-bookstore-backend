package codegym.mod5.bookstore.repository;

import codegym.mod5.bookstore.model.BookOrder;
import codegym.mod5.bookstore.model.BooksByOrder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
