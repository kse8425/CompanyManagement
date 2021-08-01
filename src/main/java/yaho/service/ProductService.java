package yaho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yaho.domain.Product;
import yaho.repasitory.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void register(Product product) {
        productRepository.save(product);
    }

    public List<Product>List(){
        return productRepository.findAll();
    }
}
