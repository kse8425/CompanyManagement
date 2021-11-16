package yaho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yaho.domain.Company;
import yaho.domain.Product;
import yaho.form.ProductForm;
import yaho.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void create(Product product) {
        productRepository.save(product);
    }

    public List<Product> readAll(){
        return productRepository.findAll();
    }

    @Transactional
    public void update(Long id, ProductForm productForm) {
        Product product = productRepository.findById(id).get();
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        productRepository.save(product);
    }

    @Transactional
    public void delete(Long id){
        productRepository.deleteById(id);
    };

    public Product findByName(String productName) {
        return productRepository.findByName(productName);
    }

    public Product findByNameLike(String productName) {
        if (productName == "") return null;
        return productRepository.findByNameLike(productName);
    }
}
