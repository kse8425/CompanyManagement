package yaho.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yaho.domain.Product;
import yaho.form.ProductForm;
import yaho.service.CompanyService;
import yaho.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    String productsRead(Model model) {
        model.addAttribute("productForm", new ProductForm());

        List<Product> productList = productService.readAll();
        model.addAttribute("productList", productList);
        return "products/total_list";
    }

    @PostMapping("/products")
    String productsCreate(ProductForm productForm) {
        Product product = new Product();
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        productService.create(product);
        return "redirect:/products";
    }

    @ResponseBody
    @PutMapping("/product/{productId}")
    List<Product> productsUpdate(@PathVariable("productId")Long productId, @RequestBody ProductForm productForm){
        productService.update(productId,productForm);
        List<Product> productList = productService.readAll();
        return productList;
    }

    @ResponseBody
    @DeleteMapping("/product/{productId}")
    List<Product> productsDelete(@PathVariable("productId")Long productId) {
        productService.delete(productId);
        List<Product> productList = productService.readAll();
        return productList;
    }
}
