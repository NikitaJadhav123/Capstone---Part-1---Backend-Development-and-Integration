package com.upgrad.productapp.utils;

import com.upgrad.productapp.dtos.EshopProductDto;
import com.upgrad.productapp.dtos.EshopShippingAddressDto;
import com.upgrad.productapp.dtos.EshopUserDto;
import com.upgrad.productapp.entities.EshopProduct;
import com.upgrad.productapp.entities.EshopShippingAddress;
import com.upgrad.productapp.entities.EshopUser;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DTOEntityConverter {


    public EshopUser convertToUserEntity(EshopUserDto userDto) {
        EshopUser usersData = new EshopUser();
        usersData.setFirstName(userDto.getFirstName());
        usersData.setLastName(userDto.getLastName());
        usersData.setEmail(userDto.getEmail());
        usersData.setPhoneNo(userDto.getPhoneNumber());
        usersData.setPassword(userDto.getPassword());
        usersData.setUserName(userDto.getUserName());
        usersData.setId(userDto.getId());
        usersData.setCreated(userDto.getCreated());
        usersData.setUpdated(userDto.getUpdated());
        usersData.setRole(userDto.getRole());
        return usersData;
    }

    public EshopShippingAddress convertToAddressEntity(EshopShippingAddressDto addressDto){
        EshopShippingAddress addressData= new EshopShippingAddress();
        addressData.setCity(addressDto.getCity());
        addressData.setLandmark(addressDto.getLandmark());
        addressData.setName(addressDto.getName());
        addressData.setPhone(addressDto.getPhone());
        addressData.setState(addressDto.getState());
        addressData.setStreet(addressDto.getStreet());
        addressData.setZipcode(addressDto.getZipcode());

        return addressData;
    }

    public EshopProduct convertToProductEntity(EshopProductDto productDto) {
        EshopProduct productData= new EshopProduct();
        productData.setAvailable_items(productDto.getAvailableItems());
        productData.setCategory(productDto.getCategory());
        productData.setCreated(LocalDateTime.now());
        productData.setDescription(productDto.getDescription());
        productData.setImage_url(productDto.getImageUrl());
        productData.setManufacturer(productDto.getManufacturer());
        productData.setName(productDto.getName());
        productData.setPrice(productDto.getPrice());
        productData.setUpdated(LocalDateTime.now());


        return productData;
    }










}
