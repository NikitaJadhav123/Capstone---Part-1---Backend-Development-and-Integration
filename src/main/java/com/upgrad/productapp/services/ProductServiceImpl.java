package com.upgrad.productapp.services;

import com.upgrad.productapp.daos.EshopProductDAO;
import com.upgrad.productapp.entities.EshopProduct;
import com.upgrad.productapp.exceptions.ProductDetailsNotFound;
import com.upgrad.productapp.utils.EntityDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("eshopProductDAO")
    private EshopProductDAO eshopProductDAO;

    @Autowired
    EntityDTOConverter entityDTOConverter;


    @Override
    public EshopProduct saveProduct(EshopProduct product) {

        return eshopProductDAO.save(product);
    }


    @Override
    public void deleteProduct(EshopProduct product) {
         eshopProductDAO.delete(product);
    }

    /*
    public EshopProduct getProductDetailsByGet(String category,String name) throws ProductDetailsNotFound {
        EshopProduct product=new EshopProduct();
        if(category!=null) {
          product = eshopProductDAO.findByCategory(category).orElseThrow(
                    () -> new ProductDetailsNotFound("Product not found for " + category));
        }

        if(name!=null) {
            product = eshopProductDAO.findByCategory(name).orElseThrow(
                    () -> new ProductDetailsNotFound("Product not found for " + name));
        }


        return product;
    }
*/
    public List<EshopProduct> getProductDetails() {
       List<EshopProduct> product=eshopProductDAO.findAll();


        return product;
    }

    public EshopProduct getProductDetailsById(int id) throws ProductDetailsNotFound {
        EshopProduct product=eshopProductDAO.findById(id).orElseThrow(
                    () -> new ProductDetailsNotFound("Product not found for " + id));

        return product;
    }


    public List<EshopProduct> getProductDetailsByCategory(String category) throws ProductDetailsNotFound  {
        List<EshopProduct> product=eshopProductDAO.findByCategory(category);

        return product;
    }

    public double getProductAmountById(int id) throws ProductDetailsNotFound {
        EshopProduct product=eshopProductDAO.findById(id).orElseThrow(
                () -> new ProductDetailsNotFound("Product not found for " + id));

        return product.getPrice();
    }


    public List<String> getProductCategories() throws ProductDetailsNotFound {
        List<EshopProduct> eshopProductList=eshopProductDAO.findAll();
        List<String> categories=new ArrayList<String>();


        for(EshopProduct p:eshopProductList){
        //   EshopProductDto productDto=entityDTOConverter.convertToProductDto(p);
            categories.add(p.getCategory());
        }

        return categories;

    }



}
