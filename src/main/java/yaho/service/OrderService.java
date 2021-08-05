package yaho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yaho.domain.Order;
import yaho.repasitory.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void add(Order order) {
        orderRepository.save(order);
    }

    public List<Order> orderList() {
        return orderRepository.findAll();
    }
}
