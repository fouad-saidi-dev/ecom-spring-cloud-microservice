package com.fouadev.customerservice;

import com.fouadev.customerservice.config.CustomerConfigParams;
import com.fouadev.customerservice.entities.Customer;
import com.fouadev.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("fouad").email("fouad@localhost.com")
                    .build());

            customerRepository.save(Customer.builder()
                    .name("reda").email("reda@localhost.com")
                    .build());

            customerRepository.save(Customer.builder()
                    .name("mohamed").email("mohamed@localhost.com")
                    .build());

            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer.toString());
                System.out.println("*******************");
            });
        };
    }
}
