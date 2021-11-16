package yaho.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yaho.domain.Company;
import yaho.domain.Order;
import yaho.domain.Product;
import yaho.form.OrderForm;
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

    @GetMapping("/orders")
    String ordersRead(Model model) {
        model.addAttribute("orderForm",new OrderForm());

        List<Order> orderList = orderService.readAllByDesc();
        model.addAttribute("orderList",orderList);
        return "orders/total_list";
    }

    @PostMapping("orders")
    String ordersCreate(OrderForm orderForm) {
        Company company = companyService.findByName(orderForm.getCompanyName());
        Product product = productService.findByName(orderForm.getProductName());
        Order order = new Order(company,product);
        order.setQuantity(orderForm.getQuantity());
        orderService.create(order);
        return "redirect:/orders";
    }

    @ResponseBody
    @PutMapping
    List<Order> orderUpdate(@PathVariable Long orderId, OrderForm orderForm) {
        return null;
    }

    @ResponseBody
    @DeleteMapping("/order/{orderId}")
    List<Order> orderDelete(@PathVariable Long orderId){
        orderService.delete(orderId);
        List<Order> orderList = orderService.readAll();
        return orderList;
    }

    
    //등록된 회사명 추천 (ajax 통신)
    @PostMapping("order/add/companySuggest")
    String companySuggest(Model model,OrderForm orderForm) {
        String companyName = orderForm.getCompanyName();
        String namesByMatch = companyService.findByNameLike(companyName).getName();
        model.addAttribute("suggestedList",namesByMatch);
        return "order/add :: #company_suggest_box";
    }

    //등록된 제품명 추천 (ajax 통신)
    @PostMapping("order/add/productSuggest")
    String productSuggest(Model model,OrderForm orderForm) {
        String productName = orderForm.getProductName();
        String namesByMatch = productService.findByNameLike(productName).getName();
        model.addAttribute("suggestedList",namesByMatch);
        return "order/add :: #product_suggest_box";
    }
}
