package com.upgrad.productapp.utils;

import com.upgrad.productapp.dtos.EshopShippingAddressDto;
import com.upgrad.productapp.dtos.EshopUserDto;
import com.upgrad.productapp.entities.EshopShippingAddress;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.UserAlreadyExistsException;
import com.upgrad.productapp.exceptions.UserDetailsNotfoundException;
import org.springframework.stereotype.Component;

@Component
public class DTOEntityConverter {


    public EshopUser convertToUserEntity(EshopUserDto userDto) throws UserDetailsNotfoundException, UserAlreadyExistsException {
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

    public EshopShippingAddress convertToAddressEntity(EshopShippingAddressDto addressDto) throws UserDetailsNotfoundException, UserAlreadyExistsException {
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










}
