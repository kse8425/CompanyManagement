package yaho.repasitory;

import org.springframework.stereotype.Repository;
import yaho.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    private Map<Integer, Product> ProductList = new HashMap<>();
    int id = 0;
    public void save(Product product) {
        product.setId(++id);
        ProductList.put(id, product);
    }

    public List<Product> findAll() {
        return new ArrayList<>(ProductList.values());
    }

    public Product findByName(String productName) {
        return findAll().stream().filter(product -> product.getName().equals(productName)).findFirst().get();
    }
}
