package com.upgrad.productapp.validators;

import com.upgrad.productapp.dtos.EshopOrderDto;
import com.upgrad.productapp.exceptions.APIException;
import org.springframework.stereotype.Service;

@Service
public class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validateOrder(EshopOrderDto eshopOrderDto) throws APIException {
        if(eshopOrderDto.getAddressId()<0)
            throw new APIException("Invalid address id");
        if(eshopOrderDto.getProductId() <0)
            throw new APIException("Invalid product id");

    }
}
