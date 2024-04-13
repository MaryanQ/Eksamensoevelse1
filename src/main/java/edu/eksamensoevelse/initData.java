package edu.eksamensoevelse;

import edu.eksamensoevelse.Service.ProductService;
import edu.eksamensoevelse.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class initData implements CommandLineRunner {
    @Override
    public static void main(String[] args) throws Exception {
        System.out.println("Creating initial data...");
        createInitialData();
    }

    private void createInitialData() {
        System.out.println("Creating initial data...");
        List<Product> products = new ArrayList<>();
products.add( new Product(ky-))
    }
}
