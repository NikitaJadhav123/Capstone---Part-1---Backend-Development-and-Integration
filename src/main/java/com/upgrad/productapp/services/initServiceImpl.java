package com.upgrad.productapp.services;

import com.upgrad.productapp.daos.EshopUserDAO;
import com.upgrad.productapp.entities.EshopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Service("InitService")
public class initServiceImpl implements InitService {





    EshopUser users = new EshopUser(LocalDateTime.now(), "admin@upgrad.com", "admin", "admin", "password", "1234567890", "ADMIN", LocalDateTime.now(), "admin");

    List<EshopUser> usersDataList=Arrays.asList( users);






    @Qualifier("eshopUserDAO")
    @Autowired
    private EshopUserDAO usersDAO;




    @Override
    public void init() {

        usersDataList.forEach(usersData -> usersDAO.save(usersData));

    }


}
