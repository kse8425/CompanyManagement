package yaho.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yaho.domain.Product;
import yaho.repository.ProductRepository;
import yaho.repository.ProductRepositoryByMemory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryByMemoryTest {

    ProductRepository productRepository = new ProductRepositoryByMemory();
    Product product;

    @BeforeEach
    void beforeEach() {
        product = new Product("SR057", 44000);
        productRepository.save(product);
    }

    @Test
    void findByName() {
        Product find = productRepository.findByName("SR057");
        assertEquals("SR057",find.getName());
    }

    @Test
    void findAll() {
        Product product1 = new Product("SR057", 44000);
        Product product2 = new Product("SR069", 55000);
        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> productList = productRepository.findAll();

        assertTrue(productList.stream().anyMatch(product -> product.getName().equals(product1.getName())));
        assertTrue(productList.stream().anyMatch(product -> product.getName().equals(product2.getName())));

    }
}
