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

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @Test
    @DisplayName("제품 추가")
    void productTest() {
        //준비
        Product product1 = new Product("SR057", 40000);
        Product product2 = new Product("SR050", 40000);

        //실행
        productService.add(product1);
        productService.add(product2);
        List<Product> findProductList = productService.list();

        //검사
        assertTrue(findProductList.contains(product1));
        assertTrue(findProductList.contains(product2));
    }

    @Test
    @DisplayName("이름으로 찾기")
    void findByName(){
        //준비
        Product product1 = new Product("SR057", 40000);
        Product product2 = new Product("SR050", 40001);
        productService.add(product1);
        productService.add(product2);

        //실행
        Product find = productService.findByName("SR050");

        //검사
        assertEquals(40001,find.getPrice());
    }

}