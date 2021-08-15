package yaho.repository;

import yaho.domain.Product;

import java.util.List;

public interface ProductRepository {
    public Long save(Product product);

    public Product findByName(String productName);

    public List<Product> findAll();
}
