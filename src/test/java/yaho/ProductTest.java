package yaho;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yaho.domain.Product;
import yaho.repasitory.ProductRepository;
import yaho.service.ProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTest {

    @Autowired ProductRepository productRepository;
    @Autowired ProductService productService;

    @Test
    @DisplayName("서비스 테스트")
    void serviceTest(){
        //준비
        Product product1 = new Product("SR057", 40000);
        Product product2 = new Product("SR050", 40000);

        //실행
        productService.register(product1);
        productService.register(product2);
        List<Product> findProductList = productService.List();

        //검사
        assertTrue(findProductList.contains(product1));
        assertTrue(findProductList.contains(product2));
    }
    
    @Test
    @DisplayName("저장소 테스트")
    void RepositoryTest(){
        //준비
        Product product1 = new Product("SR057", 40000);
        Product product2 = new Product("SR050", 40000);

        //실행
        productRepository.save(product1);
        productRepository.save(product2);
        List<Product> findProductList = productRepository.findAll();

        //검사
        assertTrue(findProductList.contains(product1));
        assertTrue(findProductList.contains(product2));
    }

}