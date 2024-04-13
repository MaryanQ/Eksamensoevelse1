package edu.eksamensoevelse.Service;


import edu.eksamensoevelse.entity.Delivery;
import edu.eksamensoevelse.entity.Product;
import edu.eksamensoevelse.entity.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eksamensoevelse.Respository.DeliveryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRespository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRespository) {
        this.deliveryRespository = deliveryRespository;
    }

    public Delivery createDelivery(Delivery delivery) {

        return deliveryRespository.save(delivery);
    }

    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRespository.findById(id);
    }

    public List<Delivery> getAllDeliveries() {

        return deliveryRespository.findAll();
    }

    public void saveDelivery(Delivery delivery) {

        deliveryRespository.save(delivery);
    }

    public Map<String, Double> calculateTotalPriceAndWeight(Long deliveryId) {
        Optional<Delivery> optionalDelivery = deliveryRespository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            List<ProductOrder> productOrders = delivery.getProductOrders();

            double totalPrice = 0.0;
            double totalWeight = 0.0;

            for (ProductOrder productOrder : productOrders) {
                Product product = productOrder.getProduct();
                totalPrice += product.getPrice();
                totalWeight += product.getWeightInGram();
            }

            Map<String, Double> result = new HashMap<>();
            result.put("totalPrice", totalPrice);
            result.put("totalWeight", totalWeight);
            return result;
        } else {
            throw new DeliveryNotFoundException("Delivery not found with ID: " + deliveryId);
        }
    }


}
