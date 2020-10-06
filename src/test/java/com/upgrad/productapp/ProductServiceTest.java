package com.upgrad.productapp;

import com.upgrad.productapp.daos.EshopProductDAO;
import com.upgrad.productapp.entities.EshopProduct;
import com.upgrad.productapp.exceptions.ProductDetailsNotFound;
import com.upgrad.productapp.services.ProductService;
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
public class ProductServiceTest {


    static EshopProduct product;

    @BeforeEach
    public void setUpTestMockData() {

        EshopProduct product = new EshopProduct(50, "Automotive", LocalDateTime.now(), "Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) Price: Rs. 1 899 Beat the heat this summer and feel like a VIP with Himmlisch Car Window Magnetic Sunshades. These magnetic sunshades create a mesh layer to stops the heat. Magnet border gets easily stick to your car window door edges (No need of Suction cups) Features: Block UV Rays Keeps Car Cool Easy to install and remove Durable and Exact Fit Provides Complete privacy Resists Heat Mesh Type Sunshade Package Contents: 1 x Set Of 4 Magnetic Sunshades Specifications of Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) General Brand Himmlisch Model Number ST381 Magnetic Placement Position Side Window Color Black Dimensions Weight 4000 g Depth 1.1 cm In the Box Sales Package 4 Sun Shade Pack of 4", "http://img5a.flixcart.com/image/sun-shade/5/2/y/pp48-car-magnetic-himmlisch-1100x1100-imaegujvyzrc8eh6.jpeg", "Himmlisch", "Himmlisch ST381 Magnetic Sun Shade For Maruti Alto", 6999, LocalDateTime.now());
        productDAO.save(product);

    }


    @Test
    public void BookingAmountTest() {
        Assertions.assertThrows(ProductDetailsNotFound.class, () -> productService.saveProduct(product));
    }


    @Autowired
    private ProductService productService;

    @Qualifier("eshopProductDAO")
    @Autowired
    private EshopProductDAO productDAO;


}