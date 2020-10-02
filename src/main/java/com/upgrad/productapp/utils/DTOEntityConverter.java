package com.upgrad.productapp.utils;

import com.upgrad.productapp.dtos.EshopOrderDto;
import com.upgrad.productapp.dtos.EshopProductDto;
import com.upgrad.productapp.dtos.EshopShippingAddressDto;
import com.upgrad.productapp.dtos.EshopUserDto;
import com.upgrad.productapp.entities.EshopOrder;
import com.upgrad.productapp.entities.EshopProduct;
import com.upgrad.productapp.entities.EshopShippingAddress;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.AddressNotFound;
import com.upgrad.productapp.exceptions.ProductDetailsNotFound;
import com.upgrad.productapp.services.AddressService;
import com.upgrad.productapp.services.ProductService;
import com.upgrad.productapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DTOEntityConverter {


    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    AddressService addressService;


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

    public EshopOrder convertToOrderEntity(EshopOrderDto orderDto) throws ProductDetailsNotFound, AddressNotFound {
        EshopOrder orderData= new EshopOrder();
        orderData.setEshopProduct(productService.getProductDetailsById((orderDto.getProductId())));
        orderData.setEshopShippingAddress(addressService.getAddressDetailsById(orderDto.getAddressId()));
        orderData.setAmount(productService.getProductAmountById(orderDto.getProductId()));
        orderData.setOrderDate(LocalDateTime.now());

        return orderData;
    }










}
