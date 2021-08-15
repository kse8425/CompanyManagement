package yaho.repository;

import org.springframework.stereotype.Repository;
import yaho.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductRepositoryByMemory implements ProductRepository{
    private Map<Long, Product> ProductList = new HashMap<>();
    Long id = 0L;

    @Override
    public Long save(Product product) {
        product.setId(++id);
        ProductList.put(id, product);
        return product.getId();
    }

    @Override
    public Product findByName(String productName) {
        return findAll().stream().filter(product -> product.getName().equals(productName)).findFirst().get();
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(ProductList.values());
    }
}
