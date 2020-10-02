package com.upgrad.productapp.services;

import com.upgrad.productapp.entities.EshopOrder;

import java.util.List;

public interface OrderService {


    EshopOrder createOrder(EshopOrder order);
    public List<EshopOrder> getOrders();
}
