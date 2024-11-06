package com.fouadev.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fouadev.billingservice.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 Created by : Fouad SAIDI on 06/11/2024
 @author : Fouad SAIDI
 @date : 06/11/2024
 @project : project-mircoservice
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private int quantity;
    private double price;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    @Transient
    private Product product;
}