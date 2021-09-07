package yaho.repository;

import yaho.domain.Company;
import yaho.domain.Order;

import java.util.List;

public interface OrderRepository {

    public Order findByID(Long id);

    public Long save(Order order);

    public List<Order> findAll();

    void deleteById(Long id);
}
