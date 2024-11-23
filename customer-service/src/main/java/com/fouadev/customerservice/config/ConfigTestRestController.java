package com.fouadev.customerservice.config;

import com.fouadev.customerservice.entities.Customer;
import com.fouadev.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
@CrossOrigin(origins = "http://localhost:4200")
public class ConfigTestRestController {

    @Value("${global.params.p1}")
    private String p1;

    @Value("${global.params.p2}")
    private String p2;
    @Autowired
    private CustomerConfigParams params;
    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/test1")
    public Map<String, String> test1() {
        return Map.of("p1", p1, "p2", p2);
    }
    @GetMapping("/test2")
    public CustomerConfigParams test2() {
        return params;
    }

    @PostMapping( value = "add-customer",produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomer(@RequestBody Customer customer){
        try {
            Customer saveCustomer = Customer.builder()
                    .name(customer.getName())
                    .email(customer.getEmail())
                    .build();

            return customerRepository.save(saveCustomer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("test/customers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}