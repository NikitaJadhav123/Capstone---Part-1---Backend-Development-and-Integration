package com.upgrad.productapp.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EshopProductDto {

    private String name; //: "automotive product",
     private String  category; //": "Automotive",
    private double price; //: 1000,
    private String description; //": "This is a cool automotive product",
    private String manufacturer; //": "Automotive manufacturer",
    private int availableItems; //: 20,
    private String imageUrl; //": "image url"

    private LocalDateTime created;

    private LocalDateTime updated;
}
