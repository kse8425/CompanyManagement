package yaho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yaho.domain.Order;
import yaho.form.OrderForm;
import yaho.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public void create(Order order) {
        orderRepository.save(order);
    }

    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    public List<Order> readAllByDesc() {
        return orderRepository.findAllByOrderByDateDesc();
    }

    @Transactional
    public void update(Long id, OrderForm orderForm) {
        Order order = orderRepository.findById(id).get();

        orderRepository.save(order);
    }

    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
