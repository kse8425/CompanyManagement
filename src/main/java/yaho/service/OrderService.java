package yaho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yaho.domain.Order;
import yaho.form.OrderForm;
import yaho.repository.OrderRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final CompanyService companyService;
    private final ProductService productService;

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
        order.setDate(LocalDate.parse(orderForm.getDate()));
        order.setCompany(companyService.findByName(orderForm.getCompanyName()));
        order.setProduct(productService.findByName(orderForm.getProductName()));
        order.setQuantity(orderForm.getQuantity());
        orderRepository.save(order);
    }

    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Order buildOrder(OrderForm orderForm) {
        Order order = new Order();
        order.setDate(LocalDate.parse(orderForm.getDate(), DateTimeFormatter.ISO_DATE));
        order.setCompany(companyService.findByName(orderForm.getCompanyName()));
        order.setProduct(productService.findByName(orderForm.getProductName()));
        order.setQuantity(orderForm.getQuantity());
        return order;
    }
}
