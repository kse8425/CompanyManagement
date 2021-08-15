package yaho.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import yaho.domain.Product;
import yaho.repository.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductRepositoryByH2Test {

    @Autowired
    ProductRepository productRepository;
    Product product;

    @BeforeEach
    void beforeEach() {
        product = new Product("SR057", 44000);
        productRepository.save(product);
    }

    @Test
    void findByName() {
        Product find = productRepository.findByName("SR057");
        assertEquals(product.getName(),find.getName());
    }

    @Test
    void findAll() {
        Product product2 = new Product("SR0572", 44002);
        Product product3 = new Product("SR0573", 44003);
        productRepository.save(product2);
        productRepository.save(product3);
        List<Product> productList = productRepository.findAll();

        assertTrue(productList.stream().anyMatch(prd->prd.getName().equals(product.getName())));
        assertTrue(productList.stream().anyMatch(prd->prd.getName().equals(product2.getName())));
        assertTrue(productList.stream().anyMatch(prd->prd.getName().equals(product3.getName())));

    }
}
