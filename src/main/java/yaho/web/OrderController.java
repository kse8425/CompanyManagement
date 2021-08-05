package yaho.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import yaho.domain.Company;
import yaho.domain.Order;
import yaho.domain.Product;
import yaho.service.CompanyService;
import yaho.service.OrderService;
import yaho.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CompanyService companyService;
    private final ProductService productService;

    @GetMapping("order/add")
    String orderAdd(Model model) {
        model.addAttribute(new OrderForm());
        return "order/add";
    }

    @PostMapping("order/add")
    String orderAdd(OrderForm orderForm) {
        Company company = companyService.findByName(orderForm.getCompanyName());
        Product product = productService.findByName(orderForm.getProductName());
        Order order = new Order(company,product);
        order.setQuantity(orderForm.getQuantity());
        orderService.add(order);
        return "redirect:/";
    }
    @GetMapping("order/list")
    String orderList(Model model) {
        List<Order> orderList = orderService.orderList();
        model.addAttribute("orderList",orderList);
        return "order/list";
    }
}
