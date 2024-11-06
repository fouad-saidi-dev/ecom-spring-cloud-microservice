package com.fouadev.billingservice.web;

import com.fouadev.billingservice.entities.Bill;
import com.fouadev.billingservice.feign.CustomerRestClient;
import com.fouadev.billingservice.feign.ProductRestClient;
import com.fouadev.billingservice.repositories.BillRepository;
import com.fouadev.billingservice.repositories.ProductItemRepository;
import jakarta.ws.rs.Path;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 Created by : Fouad SAIDI on 06/11/2024
 @author : Fouad SAIDI
 @date : 06/11/2024
 @project : project-mircoservice
*/
@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }
    @GetMapping("/bills/{id}")
    public Bill getBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi -> {
            pi.setProduct(productRestClient.findById(pi.getProductId()));
        });
        return bill;
    }
}