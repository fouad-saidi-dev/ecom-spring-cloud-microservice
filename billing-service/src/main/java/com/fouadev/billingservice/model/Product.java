package com.fouadev.billingservice.model;

import lombok.Getter;
import lombok.Setter;

/*
 Created by : Fouad SAIDI on 06/11/2024
 @author : Fouad SAIDI
 @date : 06/11/2024
 @project : project-mircoservice
*/
@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}