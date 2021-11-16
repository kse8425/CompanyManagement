package yaho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yaho.domain.Company;
import yaho.domain.Order;
import yaho.domain.Product;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findById(long id);

    List<Order> findAllByOrderByDateDesc();

    List<Order> findByDateBetween(LocalDate start,LocalDate end);

    List<Order> findByProduct(Product product);

    List<Order> findByProductAndDateBetween(Product product, LocalDate start,LocalDate end);

    List<Order> findByCompanyAndDateBetween(Company company, LocalDate start, LocalDate end);
}
