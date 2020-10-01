package com.upgrad.productapp.utils;

import com.upgrad.productapp.dtos.EshopUserDto;
import com.upgrad.productapp.dtos.LoginDTO;
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

    public EshopUser convertToLogin(LoginDTO userDto) throws UserDetailsNotfoundException, UserAlreadyExistsException {
        EshopUser usersData = new EshopUser();
        usersData.setPassword(userDto.getPassword());
        usersData.setUserName(userDto.getUserName());
        return usersData;
    }







}
