package com.upgrad.productapp.daos;

import com.upgrad.productapp.entities.EshopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("eshopProductDAO")
public interface EshopProductDAO  extends JpaRepository<EshopProduct,Integer> {


  //  Optional<EshopProduct> findByCategory(String category);


   List<EshopProduct> findByCategory(String category);

    List<EshopProduct> findAll();

    Optional<EshopProduct> findById(int id);

    Optional<EshopProduct> findByName(String name);



}
