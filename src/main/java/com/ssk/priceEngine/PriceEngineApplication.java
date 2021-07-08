package com.ssk.priceEngine;

import com.ssk.priceEngine.model.Product;
import com.ssk.priceEngine.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PriceEngineApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PriceEngineApplication.class, args);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        // Populate product table with product details.
        List<Product> products = new ArrayList<>();
        products.add(new Product("Penguin-ears", 20, 175));
        products.add(new Product("Horseshoe", 5, 825));

        productRepository.saveAll(products);
    }

}
