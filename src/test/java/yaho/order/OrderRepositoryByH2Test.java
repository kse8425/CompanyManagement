package yaho.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import yaho.domain.Company;
import yaho.domain.Order;
import yaho.domain.Product;
import yaho.repository.CompanyRepository;
import yaho.repository.OrderRepository;
import yaho.service.CompanyService;
import yaho.service.ProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderRepositoryByH2Test {

    @Autowired CompanyService companyService;
    @Autowired ProductService productService;
    @Autowired OrderRepository orderRepository;

    Company company1, company2;
    Product product1, product2;

    Order order1,order2;

    @BeforeEach
    void save() {
        company1 = new Company("kse1", "123123");
        company2 = new Company("kse2", "123123");
        product1 = new Product("sr0571", 44000);
        product2 = new Product("sr0572", 44000);
        order1 = new Order(company1, product1);
        order2 = new Order(company2, product2);

        companyService.add(company1);
        companyService.add(company2);
        productService.add(product1);
        productService.add(product2);
        orderRepository.save(order1);
        orderRepository.save(order2);
    }

    @Test
    void findAll() {
        List<Order> orderList = orderRepository.findAll();
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