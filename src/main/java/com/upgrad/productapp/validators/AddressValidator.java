package com.upgrad.productapp.validators;

import com.upgrad.productapp.dtos.EshopShippingAddressDto;
import com.upgrad.productapp.exceptions.APIException;

public interface AddressValidator {


    public void validateAddress(EshopShippingAddressDto addressDto) throws APIException;

}
