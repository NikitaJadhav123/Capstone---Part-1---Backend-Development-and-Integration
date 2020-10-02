package com.upgrad.productapp.daos;

import com.upgrad.productapp.entities.EshopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("eshopOrderDAO")
public interface EshopOrderDAO extends JpaRepository<EshopOrder,Integer> {

}
