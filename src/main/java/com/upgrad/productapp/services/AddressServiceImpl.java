package com.upgrad.productapp.services;

import com.upgrad.productapp.daos.EshopShippingAddressDAO;
import com.upgrad.productapp.entities.EshopShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("AddressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    @Qualifier("eshopShippingDAO")
    private EshopShippingAddressDAO addressDAO;


    @Override
    public EshopShippingAddress createAddress(EshopShippingAddress address) {

        return addressDAO.save(address);
    }
}
