package edu.eksamensoevelse;

import edu.eksamensoevelse.Service.DeliveryService;
import edu.eksamensoevelse.entity.Delivery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import edu.eksamensoevelse.entity.Product;
import edu.eksamensoevelse.Service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}

@Component
class InitData implements CommandLineRunner {

    private final ProductService productService;
    private final DeliveryService deliveryService;

    public InitData(ProductService productService, DeliveryService deliveryService) {
        this.productService = productService;
        this.deliveryService = deliveryService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating initial data...");

        // Create initial products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Piatto Del Giorno Pasta", 5.0, 400));
        products.add(new Product("Harvest Best bønner", 5.0, 242));
        products.add(new Product("Hindbær", 12.0, 125));
        products.add(new Product("Premier multipak is", 28.0, 445));
        products.add(new Product("OTA solgryn", 18.0, 950));



        // Save products to the database
        for (Product product : products) {
            productService.createProduct(product);
        }
        // Create  deliveries
        List<Delivery> deliveries = new ArrayList<>();
        deliveries.add(new Delivery(LocalDate.now(), "Warehouse A", "Destination 1"));
        deliveries.add(new Delivery(LocalDate.now(), "Warehouse B", "Destination 2"));
        deliveries.add(new Delivery(LocalDate.now(), "Warehouse C", "Destination 3"));

        // Save deliveries to the database
        for (Delivery delivery : deliveries) {
            deliveryService.createDelivery(delivery);
        }



        System.out.println("Initial data created successfully.");
    }
}

