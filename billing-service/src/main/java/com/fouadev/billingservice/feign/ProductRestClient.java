package com.fouadev.billingservice.feign;

import com.fouadev.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    Product findById(@PathVariable String id);
    @GetMapping("/api/products")
    PagedModel<Product> findAll();
}
