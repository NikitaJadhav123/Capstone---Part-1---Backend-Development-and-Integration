package com.upgrad.productapp.validators;

import com.upgrad.productapp.dtos.EshopShippingAddressDto;
import com.upgrad.productapp.exceptions.APIException;
import org.springframework.stereotype.Service;

@Service
public class AddressValidatorImpl implements AddressValidator {

    @Override
    public void validateAddress(EshopShippingAddressDto addressDto) throws APIException {
        if(addressDto.getZipcode() == null || addressDto.getZipcode().length()!= 6)
            throw new APIException("Invalid zip code!");
        if(addressDto.getPhone() == null  || addressDto.getPhone().length()!=10 )
            throw new APIException("Invalid contact number!");

    }


}
