package yaho.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yaho.domain.Company;
import yaho.domain.Order;
import yaho.domain.Product;
import yaho.repository.OrderRepository;
import yaho.repository.OrderRepositoryByMemory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryByMemoryTest {

    OrderRepository orderRepository = new OrderRepositoryByMemory();
    Order order1,order2,order3;
    Company company = new Company("kse", "12123");
    Product product1 = new Product("sr057", 44000);
    Product product2 = new Product("sr069", 44002);
    Product product3 = new Product("sr075", 44003);

    @BeforeEach
    void beforeEach() {

        order1 = new Order(company,product1);
        order2 = new Order(company,product2);
        order3 = new Order(company,product3);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

    }

    @Test
    void findAll() {

        List<Order> orderList = orderRepository.findAll();
        assertTrue(orderList.stream().anyMatch(
                order -> order.getProduct().getName()
                        .equals(product1.getName())));

        assertTrue(orderList.stream().anyMatch(
                order -> order.getProduct().getName()
                        .equals(product2.getName())));

        assertTrue(orderList.stream().anyMatch(
                order -> order.getProduct().getName()
                        .equals(product3.getName())));

    }
}