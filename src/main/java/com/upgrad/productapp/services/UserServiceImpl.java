package com.upgrad.productapp.services;

import com.upgrad.productapp.daos.EshopUserDAO;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.UserAlreadyExistsException;
import com.upgrad.productapp.exceptions.UserDetailsNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("UserService")
public class UserServiceImpl implements UserService {


    @Autowired
    @Qualifier("eshopUserDAO")
    private EshopUserDAO usersDAO;




    @Override
    public EshopUser getUserDetails(int id) throws UserDetailsNotfoundException {
        EshopUser user =usersDAO.findById(id).orElseThrow(
                ()->  new UserDetailsNotfoundException("User not found for " + id));
        return user;
    }



    @Override
        public EshopUser createUser(EshopUser users) throws UserAlreadyExistsException {


            if(usersDAO.findByEmail(users.getEmail()).isPresent()) {
                throw new UserAlreadyExistsException("Email Already Exists");
            }

            return usersDAO.save(users);
        }

    @Override
    public EshopUser getUser(String emailid,String password) throws UserDetailsNotfoundException {
            
            if(!usersDAO.findByEmail(emailid).isPresent()) {
                throw new UserDetailsNotfoundException("User not Registered");
            }
            
            if(!usersDAO.findByPassword(password).isPresent()){
                throw new UserDetailsNotfoundException("Unauthorized User");
            }

        return usersDAO.findByEmail(emailid).get();
    }

    public boolean getCustomerDetailsByEmail(String email) throws UserAlreadyExistsException{
        Optional<EshopUser> customer = usersDAO.findByEmail(email);
        if(customer.isPresent()){
            throw new UserAlreadyExistsException("Email exist");
        }
        return false;
    }

    public EshopUser getCustomerDetailsById(int id) throws UserDetailsNotfoundException {
        EshopUser customer = usersDAO.findById(id).orElseThrow(
                ()->  new UserDetailsNotfoundException("User not found for id" + id));
        return customer;
    }

   public boolean getCustomerDetailsByUserName(String un) throws UserAlreadyExistsException {
        Optional<EshopUser> customer = usersDAO.findByUserName(un);
        if(customer.isPresent()){
            throw new UserAlreadyExistsException("Username exist");
        }

        return false;
    }

    public boolean getCustomerByUserName(String un) throws UserDetailsNotfoundException {
        Optional<EshopUser> customer = usersDAO.findByUserName(un);
        if(customer.isEmpty()){
            throw new UserDetailsNotfoundException("Username not exist");
        }

        return false;
    }
    public EshopUser getCustomerInoByUserName(String un) throws UserDetailsNotfoundException {
        EshopUser customer = usersDAO.findByUserName(un).orElseThrow(
                ()->  new UserDetailsNotfoundException("User not found for username" + un));
        return customer;


    }



    @Override
    public UserDetails loadCustomerDetails(String un) throws UserDetailsNotfoundException {
        EshopUser user = usersDAO.findByUserName(un).orElseThrow(
                ()->  new UserDetailsNotfoundException("User not found for " + un));

        return  new User(user.getEmail(), user.getPassword() , new ArrayList<>());

    }


}
