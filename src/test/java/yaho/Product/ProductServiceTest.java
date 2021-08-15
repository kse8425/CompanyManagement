package yaho.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yaho.domain.Product;
import yaho.repository.ProductRepository;
import yaho.repository.ProductRepositoryByMemory;
import yaho.service.ProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    ProductRepository productRepository = new ProductRepositoryByMemory();
    ProductService productService = new ProductService(productRepository);
    Product product;

    @BeforeEach
    void beforeEach() {
        product = new Product("SR057", 44000);
        productService.add(product);
    }

    @Test
    void findByName() {
        Product find = productService.findByName("SR057");
        assertEquals("SR057",find.getName());
    }

    @Test
    void list() {
        Product product1 = new Product("SR057", 44000);
        Product product2 = new Product("SR069", 55000);
        productService.add(product1);
        productService.add(product2);

        List<Product> productList = productService.list();

        assertTrue(productList.stream().anyMatch(product -> product.getName().equals(product1.getName())));
        assertTrue(productList.stream().anyMatch(product -> product.getName().equals(product2.getName())));
    }


}