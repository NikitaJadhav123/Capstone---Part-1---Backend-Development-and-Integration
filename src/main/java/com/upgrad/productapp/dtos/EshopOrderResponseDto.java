package com.upgrad.productapp.dtos;

import com.upgrad.productapp.entities.EshopProduct;
import com.upgrad.productapp.entities.EshopShippingAddress;
import com.upgrad.productapp.entities.EshopUser;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EshopOrderResponseDto {

    private int id; // number PRIMARY KEY

    private EshopUser eshopUser;

    private EshopProduct eshopProduct;

    private EshopShippingAddress eshopShippingAddress;

    private double amount;


    private LocalDateTime orderDate;
}
