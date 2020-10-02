package com.upgrad.productapp.services;

import com.upgrad.productapp.daos.EshopOrderDAO;
import com.upgrad.productapp.entities.EshopOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier("eshopOrderDAO")
    private EshopOrderDAO eshopOrderDAO;

    @Override
    public EshopOrder createOrder(EshopOrder order) {

        return eshopOrderDAO.save(order);
    }

    public List<EshopOrder> getOrders(){
        return eshopOrderDAO.findAll();
    }
}
