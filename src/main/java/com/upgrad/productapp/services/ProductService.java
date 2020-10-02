package com.upgrad.productapp.services;

import com.upgrad.productapp.entities.EshopProduct;
import com.upgrad.productapp.exceptions.ProductDetailsNotFound;

import java.util.List;

public interface ProductService {


    EshopProduct saveProduct(EshopProduct product);

    public void deleteProduct(EshopProduct product);

    public List<String> getProductCategories() throws ProductDetailsNotFound;

    public EshopProduct getProductDetailsByGet(String category,String name) throws ProductDetailsNotFound;

    public EshopProduct getProductDetailsById(int id) throws ProductDetailsNotFound;


    public double getProductAmountById(int id) throws ProductDetailsNotFound ;

}
