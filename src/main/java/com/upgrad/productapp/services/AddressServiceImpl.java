package com.upgrad.productapp.services;

import com.upgrad.productapp.daos.EshopShippingAddressDAO;
import com.upgrad.productapp.entities.EshopShippingAddress;
import com.upgrad.productapp.exceptions.AddressNotFound;
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

    public EshopShippingAddress getAddressDetailsById(int id) throws AddressNotFound {
        EshopShippingAddress address=addressDAO.findById(id).orElseThrow(
                () -> new AddressNotFound("Address not found for " + id));

        return address;
    }

}
