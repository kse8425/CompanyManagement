package yaho.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yaho.domain.Company;
import yaho.domain.Order;
import yaho.domain.Product;
import yaho.repository.OrderRepository;
import yaho.repository.OrderRepositoryByMemory;
import yaho.service.OrderService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderServiceTest {

    private final OrderRepository orderRepository = new OrderRepositoryByMemory();
    private final OrderService orderService = new OrderService(orderRepository);

    Company company1, company2;
    Product product1, product2;

    Order order1,order2;

    @BeforeEach
    void beforeEach() {
        company1 = new Company("kse1", "123123");
        company2 = new Company("kse2", "123123");
        product1 = new Product("sr0571", 44000);
        product2 = new Product("sr0572", 44000);
        order1 = new Order(company1, product1);
        order2 = new Order(company2, product2);

        orderService.add(order1);
        orderService.add(order2);

    }

    @Test
    void list() {
        List<Order> orderList = orderService.list();
        assertTrue(orderList.stream().anyMatch(order -> order.getCompany().getName()
                .equals(company1.getName())));
        assertTrue(orderList.stream().anyMatch(order -> order.getCompany().getName()
                .equals(company2.getName())));
        assertTrue(orderList.stream().anyMatch(order -> order.getProduct().getName()
                .equals(product1.getName())));
        assertTrue(orderList.stream().anyMatch(order -> order.getProduct().getName()
                .equals(product2.getName())));
    }
}
