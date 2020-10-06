package com.upgrad.productapp;

import com.upgrad.productapp.daos.EshopUserDAO;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.UserAlreadyExistsException;
import com.upgrad.productapp.exceptions.UserDetailsNotfoundException;
import com.upgrad.productapp.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:hwBeans.xml"})
public class UserServiceTest {


    static EshopUser users;
    static int userId;


    @BeforeEach
    public void setUpTestMockData(){

        users = new EshopUser(LocalDateTime.now(), "admin@upgrad.com", "admin", "admin", "password", "1234567890", "ADMIN", LocalDateTime.now(), "admin");

        userId = usersDAO.save(users).getId();
    }



    @Test
    public void UserDetailsAlreadyExist(){
        Assertions.assertThrows(UserAlreadyExistsException.class,()->userService.createUser(users));
    }




    @Test
    public void UserDetailsNotFound(){
        Assertions.assertThrows(UserDetailsNotfoundException.class,()->userService.getUser("upgad@gmail.com","admi@123"));
    }


    @Test
    public void a(){
        Assertions.assertTrue(true);
    }


    @Autowired
    private UserService userService;

    @Qualifier("eshopUserDAO")
    @Autowired
    private EshopUserDAO usersDAO;


}

