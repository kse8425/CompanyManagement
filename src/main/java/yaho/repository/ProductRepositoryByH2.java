package yaho.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yaho.domain.Product;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryByH2 implements ProductRepository {

    private final EntityManager em;

    @Override
    public Long save(Product product) {
        em.persist(product);
        return product.getId();
    }

    @Override
    public Product findByName(String productName) {
        return em.createQuery("select p from Product p where p.name = :name",Product.class)
                .setParameter("name",productName)
                .getSingleResult();
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p",Product.class)
                .getResultList();
    }
}