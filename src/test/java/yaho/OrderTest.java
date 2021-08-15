package yaho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import yaho.domain.Company;
import yaho.domain.Order;
import yaho.domain.Product;
import yaho.service.CompanyService;
import yaho.service.OrderService;
import yaho.service.ProductService;
import yaho.web.OrderForm;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class OrderTest {

    @Autowired
    OrderService orderService;
    @Autowired CompanyService companyService;
    @Autowired ProductService productService;


    @BeforeEach
    void beforeEach() {
        Company company1 = new Company("tech roll", "444-000-555555");
        Company company2 = new Company("sec roll", "444-111-555555");
        companyService.add(company1);
        companyService.add(company2);

        Product product1 = new Product("SR005", 40000);
        Product product2 = new Product("SR006", 40000);
        productService.add(product1);
        productService.add(product2);
    }


    @Test
    @DisplayName("주문 등록")
    void orderTest() {
        Order order1 = new Order(companyService.list().get(0), productService.list().get(0));
        Order order2 = new Order(companyService.list().get(1), productService.list().get(1));

        orderService.add(order1);
        orderService.add(order2);

        List<Order> findOrder = orderService.list();

        assertTrue(findOrder.contains(order1));
        assertTrue(findOrder.contains(order2));
    }

    @Test
    @DisplayName("주문 폼 검사")
    void orderFormTest() {
        OrderForm orderForm = new OrderForm();
        orderForm.setCompanyName("tech roll");
        orderForm.setProductName("SR005");

        Company findCom = companyService.findByName(orderForm.getCompanyName());
        Product findPro = productService.findByName(orderForm.getProductName());
        Order order = new Order(findCom,findPro);

        assertEquals(findCom.getName(),order.getCompany().getName());

    }
}