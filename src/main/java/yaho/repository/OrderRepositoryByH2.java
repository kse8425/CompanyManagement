package yaho.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yaho.domain.Order;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryByH2 implements OrderRepository{

    private final EntityManager em;

    @Override
    public Long save(Order order) {
        em.persist(order);
        return order.getId();
    }

    @Override
    public List<Order> findAll() {
//        return em.createQuery("select o from order o join fetch o.company",Order.class)
        return em.createQuery("select o from Order o",Order.class)
                .getResultList();
    }
}
