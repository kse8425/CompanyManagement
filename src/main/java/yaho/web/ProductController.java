package yaho.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import yaho.domain.Company;
import yaho.domain.Product;
import yaho.service.CompanyService;
import yaho.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired ProductService productService;
    @Autowired
    CompanyService companyService;

    @GetMapping("product/register")
    String productRegister(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "/product/register";
    }

    @PostMapping("product/register")
    String productRegisterForm(ProductForm productForm) {

        Product product = new Product();

        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());

        productService.add(product);

        return "redirect:/";
    }
    @GetMapping("product/list")
    String productList(Model model) {
        List<Product> productList = productService.list();
        model.addAttribute("productList", productList);

        return "/product/list";
    }
}
