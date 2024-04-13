package edu.eksamensoevelse.Controller;

import edu.eksamensoevelse.Service.DeliveryService;
import edu.eksamensoevelse.entity.Delivery;
import edu.eksamensoevelse.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }
    @GetMapping("/deliveries")
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        return ResponseEntity.ok(deliveries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
        Optional<Delivery> delivery = deliveryService.getDeliveryById(id);
        return delivery
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
//vægt
    @GetMapping("/{deliveryId}/total-price-weight")
    public ResponseEntity<Map<String, Double>> getTotalPriceAndWeight(@PathVariable Long deliveryId) {
        Map<String, Double> totalPriceAndWeight = deliveryService.calculateTotalPriceAndWeight(deliveryId);
        return ResponseEntity.ok(totalPriceAndWeight);
    }

    @PostMapping("/create-deliveries")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        Delivery createdDelivery = deliveryService.createDelivery(delivery);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDelivery);
    }
}
