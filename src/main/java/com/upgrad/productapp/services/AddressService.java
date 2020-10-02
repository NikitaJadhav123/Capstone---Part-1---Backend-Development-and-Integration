package com.upgrad.productapp.services;

import com.upgrad.productapp.entities.EshopShippingAddress;
import com.upgrad.productapp.exceptions.AddressNotFound;

public interface AddressService {

    EshopShippingAddress createAddress(EshopShippingAddress address);
    public EshopShippingAddress getAddressDetailsById(int id) throws AddressNotFound;
}
