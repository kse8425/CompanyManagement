package yaho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yaho.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findById(long id);

    Product findByName(String name);

    Product findByNameLike(String name);
}
