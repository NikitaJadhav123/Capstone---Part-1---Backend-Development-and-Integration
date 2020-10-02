package com.upgrad.productapp.daos;

import com.upgrad.productapp.entities.EshopShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("eshopShippingDAO")
public interface EshopShippingAddressDAO extends JpaRepository<EshopShippingAddress,Integer> {

}
