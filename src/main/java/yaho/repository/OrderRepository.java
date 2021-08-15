package yaho.repository;

import yaho.domain.Order;

import java.util.List;

public interface OrderRepository {

    public Long save(Order order);

    public List<Order> findAll();
}
