package yaho.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import yaho.domain.Product;
import yaho.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired ProductService productService;

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

        productService.register(product);

        return "redirect:/";
    }
    @GetMapping("product/list")
    String productList(Model model) {
        List<Product> productList = productService.List();
        model.addAttribute("productList", productList);

        return "/product/list";
    }
}
