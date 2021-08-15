package yaho.repository;

import org.springframework.stereotype.Repository;
import yaho.domain.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderRepositoryByMemory implements OrderRepository{
    private Map<Long, Order> orderList = new HashMap<>();
    private Long id=0L;

    @Override
    public Long save(Order order) {
        order.setId(++id);
        orderList.put(id, order);
        return id;
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orderList.values());
    }
}
