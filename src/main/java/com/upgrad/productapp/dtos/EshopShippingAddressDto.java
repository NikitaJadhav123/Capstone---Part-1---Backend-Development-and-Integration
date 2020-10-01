package com.upgrad.productapp.dtos;

import com.upgrad.productapp.entities.EshopUser;
import lombok.Data;

@Data
public class EshopShippingAddressDto {


   private String name; //": "John Snow",
    private String phone; //": 9091929394,
    private String street; //": "The Castle Street",
    private String landmark; //": "Castle",
    private String city; //": "WinterFell",
    private String state; //": "The North",
    private String zipcode; //": "123456"

   private EshopUser user;

}
