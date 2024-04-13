package edu.eksamensoevelse.Service;

import edu.eksamensoevelse.Respository.ProductRespository;
import edu.eksamensoevelse.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        Optional<Product> optionalProduct = productRespository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setWeightInGram(updatedProduct.getWeightInGram());


            Product savedProduct = productRespository.save(existingProduct);
            return Optional.of(savedProduct);
        } else {
            return Optional.empty();
        }
    }

        public Optional<Product> deleteProduct(Long id) {
            Optional<Product> productToDelete = productRespository.findById(id);
            if (productToDelete.isPresent()) {
                productRespository.deleteById(id);
                return productToDelete;
            } else {
                return Optional.empty();
            }
        }
    }

