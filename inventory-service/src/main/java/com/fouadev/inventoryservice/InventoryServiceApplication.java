package com.fouadev.inventoryservice;

import com.fouadev.inventoryservice.entities.Product;
import com.fouadev.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Phone")
                    .price(1000)
                    .quantity(10)
                    .build()
            );

            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Laptop")
                    .price(2000)
                    .quantity(20)
                    .build()
            );

            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Tablet")
                    .price(3000)
                    .quantity(30)
                    .build()
            );

            productRepository.findAll().forEach(product -> {
                System.out.println(product.toString());
                System.out.println("*******************");
            });
        };
    }
}
