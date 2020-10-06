package com.upgrad.productapp.services;

import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.UserAlreadyExistsException;
import com.upgrad.productapp.exceptions.UserDetailsNotfoundException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    EshopUser createUser(EshopUser users) throws UserAlreadyExistsException;
    EshopUser getUser(String emailid, String password) throws UserDetailsNotfoundException;
    public boolean getCustomerDetailsByEmail(String email) throws UserDetailsNotfoundException, UserAlreadyExistsException;
    public EshopUser getCustomerDetailsById(int id) throws UserDetailsNotfoundException;
    public boolean getCustomerDetailsByUserName(String un) throws UserDetailsNotfoundException, UserAlreadyExistsException;
    public UserDetails loadCustomerDetails(String un) throws UserDetailsNotfoundException;
    EshopUser getUserDetails(int id) throws UserDetailsNotfoundException;

    public boolean getCustomerByUserName(String un) throws UserDetailsNotfoundException;
    public EshopUser getCustomerInoByUserName(String un) throws UserDetailsNotfoundException;
   // EshopUser getCustomerDetailsByMobile(String mobileNo) throws UserDetailsNotfoundException;
}
