package yaho.repasitory;

import org.springframework.stereotype.Repository;
import yaho.domain.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    private Map<Integer, Order> orderList = new HashMap<>();
    private int id=0;

    public void save(Order order) {
        order.setId(++id);
        orderList.put(id, order);
    }

    public List<Order> findAll() {
        return new ArrayList<>(orderList.values());
    }
}
