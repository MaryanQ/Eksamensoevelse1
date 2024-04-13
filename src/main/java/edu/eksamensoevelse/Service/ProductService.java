package edu.eksamensoevelse.Service;

import edu.eksamensoevelse.Respository.ProductRespository;
import edu.eksamensoevelse.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRespository productRespository;

    @Autowired
    public ProductService(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    public List<Product> getAllProducts() {
        return productRespository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRespository.findById(id);
    }
    public Optional<Product> getProductByName(String name) {
        return productRespository.findByName(name);
    }
    public Product createProduct(Product product) {
        return productRespository.save(product);
    }
}
