package yaho.repository;

import yaho.domain.Product;

import java.util.List;

public interface ProductRepository {
    public Long save(Product product);

    public Product findByName(String productName);

    public Product findById(Long id);

    public List<Product> findAll();

    List<String> findByMatch(String productName);

    void deleteByID(Long id);
}
