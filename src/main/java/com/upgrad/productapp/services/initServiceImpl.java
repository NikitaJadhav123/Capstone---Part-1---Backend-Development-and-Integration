package com.upgrad.productapp.services;

import com.upgrad.productapp.daos.EshopProductDAO;
import com.upgrad.productapp.daos.EshopUserDAO;
import com.upgrad.productapp.entities.EshopProduct;
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



    EshopProduct product=new EshopProduct(50, "Automotive", LocalDateTime.now(), "Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) Price: Rs. 1 899 Beat the heat this summer and feel like a VIP with Himmlisch Car Window Magnetic Sunshades. These magnetic sunshades create a mesh layer to stops the heat. Magnet border gets easily stick to your car window door edges (No need of Suction cups) Features: Block UV Rays Keeps Car Cool Easy to install and remove Durable and Exact Fit Provides Complete privacy Resists Heat Mesh Type Sunshade Package Contents: 1 x Set Of 4 Magnetic Sunshades Specifications of Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) General Brand Himmlisch Model Number ST381 Magnetic Placement Position Side Window Color Black Dimensions Weight 4000 g Depth 1.1 cm In the Box Sales Package 4 Sun Shade Pack of 4", "http://img5a.flixcart.com/image/sun-shade/5/2/y/pp48-car-magnetic-himmlisch-1100x1100-imaegujvyzrc8eh6.jpeg", "Himmlisch", "Himmlisch ST381 Magnetic Sun Shade For Maruti Alto", 6999, LocalDateTime.now());
    EshopProduct product1=new EshopProduct(50, "Automotive", LocalDateTime.now(), "Songbird stereo features a Anti theft Detachable Front Panel that you can simply remove  take it with you in its protective Case which will make it uninteresting  useless for the thief to theft the Car Stereo. Also, you can Select among 7 Amazing Colours Backlight illumination for your Car Stereo to match your mood or your Cars Dashboard illumination.", "https://t4.ftcdn.net/jpg/00/58/41/13/240_F_58411398_zwP6N6U62euFY4sjU33q2VRJifApoI7d.jpg", "Songbird", "Songbird sb3016 Car Stereo  (Single Din)", 1200,LocalDateTime.now());


    List<EshopProduct> productList=Arrays.asList( product,product1);



    @Qualifier("eshopUserDAO")
    @Autowired
    private EshopUserDAO usersDAO;


    @Qualifier("eshopProductDAO")
    @Autowired
    private EshopProductDAO eshopProductDAO;




    @Override
    public void init() {

        usersDataList.forEach(usersData -> usersDAO.save(usersData));

        productList.forEach( productData -> eshopProductDAO.save(productData));

    }


}
