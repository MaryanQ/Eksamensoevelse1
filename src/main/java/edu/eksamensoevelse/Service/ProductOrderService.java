package edu.eksamensoevelse.Service;

import edu.eksamensoevelse.Respository.ProductOrderRespository;
import edu.eksamensoevelse.Respository.ProductRespository;
import edu.eksamensoevelse.entity.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService {

    private final ProductOrderRespository productOrderRepository;

    @Autowired
    public ProductOrderService(ProductOrderRespository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    public ProductOrder createProductOrder(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }
    // Method to create and save a ProductOrder with specific data
    public ProductOrder createAndSaveProductOrder(Long deliveryId) {

        ProductOrder productOrder = new ProductOrder();


        return productOrderRepository.save(productOrder);
    }
}
