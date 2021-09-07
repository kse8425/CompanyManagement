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
    public Product findById(Long productId) {
        return em.find(Product.class,productId);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p",Product.class)
                .getResultList();
    }

    @Override
    public List<String> findByMatch(String productName) {
        return em.createQuery("select p.name from Product p where p.name like :name", String.class)
                .setParameter("name", "%" + productName + "%")
                .getResultList();
    }

    @Override
    public void deleteByID(Long id) {
        Product product = findById(id);
        em.remove(product);
    }
}
