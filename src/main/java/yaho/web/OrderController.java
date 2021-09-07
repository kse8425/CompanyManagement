package yaho.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/")
    String index(Model model) {
        List<Order> orderList = orderService.list();
        model.addAttribute("orderList",orderList);
        return "/index.html";
    }

    @GetMapping("order/add")
    String orderAdd(Model model) {
        List<Order> orderList = orderService.list();
        model.addAttribute(new OrderForm());
        model.addAttribute("orderList",orderList);
        return "order/add";
    }

    @PostMapping("order/add")
    String orderAdd(OrderForm orderForm) {
        Company company = companyService.findByName(orderForm.getCompanyName());
        Product product = productService.findByName(orderForm.getProductName());
        Order order = new Order(company,product);
        order.setQuantity(orderForm.getQuantity());
        orderService.add(order);
        return "redirect:/order/add";
    }

    
    //등록된 회사명 추천 (ajax 통신)
    @PostMapping("order/add/companySuggest")
    String companySuggest(Model model,OrderForm orderForm) {
        String companyName = orderForm.getCompanyName();
        List<String> namesByMatch = companyService.findByMatch(companyName);
        model.addAttribute("suggestedList",namesByMatch);
        return "order/add :: #company_suggest_box";
    }

    //등록된 제품명 추천 (ajax 통신)
    @PostMapping("order/add/productSuggest")
    String productSuggest(Model model,OrderForm orderForm) {
        String productName = orderForm.getProductName();
        List<String> namesByMatch = productService.findByMatch(productName);
        model.addAttribute("suggestedList",namesByMatch);
        return "order/add :: #product_suggest_box";
    }

    @GetMapping("order/list")
    String orderList(Model model) {
        List<Order> orderList = orderService.list();
        model.addAttribute("orderList", orderList);
        return "order/list";
    }

    @GetMapping("order/remove/{orderId}")
    String remove(@PathVariable Long orderId,Model model) {
        orderService.deleteById(orderId);
        List<Order> orderList = orderService.list();
        model.addAttribute("orderList", orderList);
        return "order/list :: .table";
    }
}
