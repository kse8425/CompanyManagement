package yaho.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import yaho.domain.Company;
import yaho.domain.Order;
import yaho.domain.Product;
import yaho.service.CompanyService;
import yaho.service.OrderService;
import yaho.service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class DashBoardControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    private Company company = Company.builder()
            .name("야호테크")
            .telNumber("010123456")
            .email("kse84@gmail")
            .location("마산")
            .build();
    private Product product = Product.builder()
            .name("테스트")
            .price(100)
            .build();
    private Order order = Order.builder()
            .company(company)
            .product(product)
            .date(LocalDate.of(2021, 12, 1))
            .quantity(12)
            .build();


    @BeforeEach
    void setup() {
//        companyService.create(company);
//        productService.create(product);
//        orderService.create(order);
    }


    @Test
    void monthlyRevenue() throws Exception {
//        List<String> labels = new ArrayList<>();
//        List<Integer> dataset = new ArrayList<>();
//
//        for (int i = 1; i < 13; i++) {
//            labels.add(i + "월");
//            dataset.add(0);
//        }
//        mockMvc.perform(get("/monthlyRevenue"))
//                .andExpect(jsonPath("labels").value(labels))
//                .andExpect(jsonPath("dataset").value(dataset));
    }

    @Test
    void thisMonthRevenue() {
    }

    @Test
    void thisWeekRevenue() {
    }

    @Test
    void bestProduct() {
    }

    @Test
    void bestCompany() {
    }
}